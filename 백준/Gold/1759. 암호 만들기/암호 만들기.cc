#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int L, C;
char a[15];

bool possible(string passwd) {
	int vowel = 0, consonant = 0;
	for (char c : passwd) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			vowel++;
		else
			consonant++;
		if (vowel >= 1 && consonant >= 2)
			return true;
	}
	return false;
}

void solve(int index, string passwd) {
	if ((int)passwd.length() == L) {
		if (possible(passwd))
			cout << passwd << '\n';
		return;
	}
	if (index >= C) return;
	solve(index + 1, passwd + a[index]);
	solve(index + 1, passwd);
}

int main() {
	cin >> L >> C;
	for (int i = 0; i < C; i++)
		cin >> a[i];
	sort(a, a + C);
	solve(0, "");
	return 0;
}