#include <iostream>

using namespace std;

int arr[100];
int selection[3]; // 고른 카드
int MAX = 0; // 골른 카드중 가장 큰 값
int size; // 카드의 갯수
int n; // 카드의 최대 크기
int sum = 0;
int count = 0; // selection의 인덱스

int val(int a[]) {
	int s = 0;
	for (int i = 0; i < 3; i++)
		s += a[i];

	return s;
}

void result(int num) {
	if (count < 3) {
		for (int i = num; i < size; i++) {
			selection[count] = arr[i];
			count++;
			result(i + 1);
			count--;
		}
	}
	else {
		sum = val(selection);
		if (MAX < sum && sum <= n) {
			MAX = sum;
		}
	}	
}
int main() {
	cin >> size >> n;

	for (int i = 0; i < size; i++)
		cin >> arr[i];

	result(0);
	cout << MAX;
}