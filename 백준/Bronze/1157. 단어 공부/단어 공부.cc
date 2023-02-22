#include<iostream>
#include<string>
using namespace std;

int main() {
	string s;
	int arr[26] = { 0 };
	int max = 0;
	char answer;
	getline(cin, s);
	// 아스키 코드를 이용해서 배열에 각 알파벳이 몇 번 나왔는지 넣어준다.
	for (int i = 0; i < s.length(); i++) {
		if (s[i] >= 65 && s[i] <= 90)
			arr[s[i] - 65] += 1;
		else if (s[i] >= 97 && s[i] <= 122)
			arr[s[i] - 97] += 1;
	}
	// 해결방법 3에 해당하는 코드
	for (int i = 0; i < 26; i++) {
		if (arr[i] > max) {
			answer = i + 65;
			max = arr[i];
		}
		else if (arr[i] == max)
			answer = '?';
	}

	cout << answer << "\n";

	return 0;
}