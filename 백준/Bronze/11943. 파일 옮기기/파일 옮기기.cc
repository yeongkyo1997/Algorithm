#include <iostream>
#include <algorithm>

using namespace std;

struct basket{
	int apple;
	int orange;
};

int main() {
	basket b[2];

	cin >> b[0].apple >> b[0].orange;
	cin >> b[1].apple >> b[1].orange;
	
	cout << min(b[0].apple + b[1].orange, b[1].apple + b[0].orange);
}