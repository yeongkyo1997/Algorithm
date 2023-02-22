#include <iostream>

using namespace std;

int main(void) {
	int n, i;

	cin >> n;

	for (i = 1; i < 10; i++)
		cout << n << " * " << i << " = " << n * i << endl;
}