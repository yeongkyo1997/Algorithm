#include <iostream>

using namespace std;

class Person {
public:
	int weight;
	int height;
	int count;

	void init() {
		Person::count = 1;
	}
};

int main() {
	Person p[50];
	int n;
	
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> p[i].weight >> p[i].height;
		p[i].init();
	}

	for (int i = 0; i < n; i++)  {
		for (int j = 0; j < n; j++) {
			if (p[i].weight < p[j].weight && p[i].height < p[j].height)
				p[i].count++;
		}
	}

	for (int i = 0; i < n; i++)
		cout << p[i].count << " ";
}