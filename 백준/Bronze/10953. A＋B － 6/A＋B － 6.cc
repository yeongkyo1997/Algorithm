#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int a, b;
	int n;
	
	cin >> n;

	for (int i = 0; i < n; i++) {
		scanf("%d,%d", &a, &b);

		cout << a + b << endl;
	}

}