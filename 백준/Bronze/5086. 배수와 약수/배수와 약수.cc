#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;



int main() { 
	int a, b;

	cin >> a >> b;

	while (a != 0 && b != 0) {
		
		if (max(a, b) % min(a, b) == 0) {
			if (a > b) 
				cout << "multiple" << "\n";
			else
				cout << "factor" << "\n";
		}
		else
			cout << "neither" << "\n";
		cin >> a >> b;
	} while (a != 0 && b != 0);
}