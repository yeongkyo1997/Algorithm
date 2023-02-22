#include <cstdio>
#include <iostream>

#define endl "\n";

using namespace std;


int main() {
	cout << "n e" << endl;
	cout << "- -----------" << endl;
	cout << "0 1\n";
	cout << "1 2\n";
	cout << "2 2.5\n";

	double factorial = 2;

	double i = 2;

	double result = 2.5;
	
	while(factorial < 9) {
		factorial++;
		i *= factorial;

		result += 1 / i;

		printf("%.0f %.9f\n", factorial, result);
	}
}