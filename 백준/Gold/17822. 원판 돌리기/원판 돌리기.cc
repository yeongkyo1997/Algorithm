#include <iostream>
#include <set>
using namespace std;
 
int n, m, t;
int board[51][51];
int tmp[51][51];
 
void rotate(int i, int count) {
	int index = 1;
	
	for (int j = count+1; j <= m; j++) {
		tmp[i][j] = board[i][index++];
	}

	for (int j = 1; j <= count; j++) {
		tmp[i][j] = board[i][index++];
	}
	
	for (int j = 1; j <= m; j++) {
        board[i][j] = tmp[i][j];
    }
}
 
 
bool removeAdj() {
	set<pair<int, int> > s;
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (board[i][j] == 0)
				continue;
			
			if (j == m) {
				if (board[i][m] == board[i][1]) {
					s.insert(make_pair(i, m));
					s.insert(make_pair(i, 1));
				}
			}
			else {
				if (board[i][j] == board[i][j + 1]) {
					s.insert(make_pair(i, j));
					s.insert(make_pair(i, j + 1));
				}
			}
		}
	}
	
	for (int j = 1; j <= m; j++) {
		for (int i = 1; i < n; i++) {
			if (board[i][j] == 0) 
				continue;

			if (board[i][j] == board[i+1][j]) {s.insert(make_pair(i, j));
			s.insert(make_pair(i + 1, j));
			}
		}
	}
	
	if (s.empty()) 
		return false;
	set<pair<int, int>> ::iterator iter;

    for (iter = s.begin(); iter != s.end(); iter++) {
		board[iter->first][iter->second] = 0;
    }
 
    return true;
}
 
void calc() {
	int sum = 0;
    int total = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (board[i][j] == 0) 
				continue;
			total += 1;
            sum += board[i][j];
        }
    }
	
	if (total == 0) 
		return;
	
	int avg = sum/total;
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (board[i][j] == 0) 
				continue;
			
			if (board[i][j] > avg)
				board[i][j] -= 1;
			else if(board[i][j] < avg)
				board[i][j] += 1;
			else {
				if (sum%total != 0) 
					board[i][j] += 1;
			}
		}
	} 
}
 
int main() {
    ios_base::sync_with_stdio(false);
    
	cin.tie(0);

    cin >> n >> m >> t;
 
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> board[i][j];
        }
    }
 
    int x, d, k;
    while (t--) {
        cin >> x >> d >> k;
 
 
        for (int i = 1; i <= n; i++) {
			if (i % x != 0)
				continue;
			
			if (d == 0) {
				rotate(i, k);
			}
			else {
				rotate(i, m - k);
			}
		}
		
		bool isRemoved = removeAdj();
		if (!isRemoved) {
			calc();
        }
    }
	
	int ans = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			ans += board[i][j];
		}
	}
	cout << ans << '\n';
}