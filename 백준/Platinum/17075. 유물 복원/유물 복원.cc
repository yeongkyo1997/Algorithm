#include <iostream>
#include <cstdio>

using namespace std;

#define Max 52

int R, C, K, m[Max][Max], t[Max][Max], sum;

bool use[Max][Max];

// (sr, sc) ~ (er, ec) '1'인 곳의 합

int calc(int sr, int sc, int er, int ec) {
	int ret = 0;

	for (int i = sr; i <= er; i++) 
		for (int j = sc; j <= ec; j++) 
			if (m[i][j] == -1) 
				++t[i][j]; // -1은 따로 t 2차원 배열에 그 횟수를 1 증가시킨다.
			else            
				ret += m[i][j];
	
	return ret;
}
 
// 한 점(r, c)을 기준으로 그 점에 대해서 모든 직사각형 안에 있는 1의 합을 구한다.
int simulation(int r, int c) {
	int ret = 0;

	for (int i = r; i < R; i++) 
		for (int j = c; j < C; j++) 
			ret += calc(r, c, i, j);
	
	return ret;
}
 
// 정답 출력(K의 배수인지 검사)
void chk(int s) {
	if ((sum + s) % K == 0) {
		printf("1\n");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (m[i][j] == -1) 
					printf("%d ", use[i][j] ? 1 : 0);

				else 
					printf("%d ", m[i][j]);

			}
			printf("\n");
		}
        exit(0);
    }
}
 
// 백트래킹
void dfs(int r, int c, int s) {    
	// K의 배수가 되는지 검사
	chk(s);

	if (c == C) {
		c = 0;
		++r;
	}

    if (r == R)
		return;
    
	if (m[r][c] == -1) {
		use[r][c] = true;
		
		dfs(r, c + 1, s + t[r][c]);
		
		use[r][c] = false;
	}
	
	// 해당 칸(r, c)을 선택(덧셈)을 안 할 때
	dfs(r, c + 1, s);
}

int main() {
	cin.tie(0);
	
	scanf("%d %d %d", &R, &C, &K);
	
	for (int i = 0; i < R; i++) 
		for (int j = 0; j < C; j++)
			scanf("%d", &m[i][j]);

	// 나올 수 있는 모든 직사각형에서 1의 합(단, -1인 곳은 t 배열에 그 횟수를 저장하였음)
	
	for (int i = 0; i < R; i++) 
		for (int j = 0; j < C; j++) 
			sum += simulation(i, j);
	
	// 백트래킹
	dfs(0, 0, 0);

	printf("-1\n");
	return 0;
}
