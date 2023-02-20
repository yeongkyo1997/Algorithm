#include <iostream>
#include <algorithm>
#include <memory>

struct arr {
	int data;
	int index;
};

using namespace std;

bool cmp(arr list1, arr list2) {
	return list1.data < list2.data;
}

bool cmp2(arr list1, arr list2) {
	return list1.index < list2. index;
}

int main() {
	arr list[8];
	int sum = 0;

	for (int i = 0; i < 8; i++) {
		cin >> list[i].data;
		list[i].index = i;
	}

	sort(list, list + 8, cmp);
	sort(list + 3, list + 8, cmp2);
	for (int i = 3; i <= 7; i++) 
		sum += list[i].data;

	cout << sum << endl;
	
	for (int i = 3; i <= 7; i++)
		cout << list[i].index + 1 << " ";
}