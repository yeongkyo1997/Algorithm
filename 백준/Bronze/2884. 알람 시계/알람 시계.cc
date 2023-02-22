#include <iostream>

using namespace std;

int main() {
	int hour, minute;

	cin >> hour >> minute;

	if ((minute - 45)  > 0)
		cout << hour << " " << minute - 45;
	else if ((minute - 45) < 0)
		if (hour - 1 > -1)
			cout << hour - 1 << " " << 60 + minute - 45;
		else
			cout << 23 << " " << 60 + minute - 45;
	else
		cout << hour << " " << minute - 45;
}