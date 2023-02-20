#include <iostream>
#include <cmath>
#define endl "\n"

using namespace std;

bool isTriple(int a, int b, int c, int d) {
	if (pow(a, 3.) == pow(b, 3.) + pow(c, 3.) + pow(d, 3.))
		return true;
	else
		return false;
}

int main() {
	int a = 100;
	
	for (int e = 2; e <= a; e++) {
		for (int i = 2; i <= e; i++) {
			for (int j = i + 1; j <= e; j++) {
				for (int k = j + 1; k <= e; k++) {
					if (isTriple(e, i, j, k) == true)
						cout << "Cube = " << e << ", Triple = (" << i << "," << j << "," << k << ")" << endl;
				}
			}
		}
	}
}