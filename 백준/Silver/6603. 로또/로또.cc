#include <iostream>
#include <algorithm>

using namespace std;

int arr[13];
int n;
int index = 0;
int temp[13];

void dfs(int num) {
	if (index < 6) {
		for (int i = num; i < n; i++) {
			temp[index++] = arr[i];
			dfs(i + 1);
			index--;
		}
	}
	else {
		for (int i = 0; i < 6; i++)
			cout<< temp[i] << " ";
		cout << endl;
	}
}

int main() {

	while (true) {
		cin >> n;
		if (n == 0)
			break;
		else {
			for (int i = 0; i < n; i++) 
				cin >> arr[i];
			dfs(0);
			cout << endl;
		}
	}
}