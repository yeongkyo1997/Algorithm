#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#define fio ios_base::sync_with_stdio(0), cin.tie(0)
using namespace std;
 
int main(int argc, char *argv[])
{
	int x[4];
	int y[4];
 
	for (int i = 0; i < 3; ++i) {
		cin >> x[i];
		cin >> y[i];
	}
 
	x[3] = x[0];
	y[3] = y[0];
 
	if (x[3] == x[1]) {
		x[3] = x[2];
	}
	else if (x[3] == x[2]) {
		x[3] = 1;
	}
 
	if (y[3] == y[1]) {
		y[3] = y[2];
	}
	else if (y[3] == y[2]) {
		y[3] = y[1];
	}
 
	cout << x[3] << " " << y[3] << endl;
 
	return 0;
}