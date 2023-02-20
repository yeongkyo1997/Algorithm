#include <iostream>

using namespace std;

int main() {
	int arr[15];
	int index = 0;

	while (true) {
		int n;
		cin >> n;
		
		if (n == -1)
			break;

		else if (n == 0) {
			int count = 0;
			for (int i = 0; i < index; i++) {
				for (int j = 0; j < index; j++) {
					if (arr[i] * 2 == arr[j]) {
						count++;
					}
				}
			}
			cout << count << endl;
			index = 0;
		}
		else
			arr[index++] = n;
	}
}