#include<iostream>
using namespace std;
int t, n;
char a[21];
int main() {
	scanf("%d", &t);
	for (int tc = 0; tc < t; tc++) {
		scanf("%d %s", &n ,a);
		for (int i = 0; a[i] != '\0'; i++)
			for (int j = 0; j < n; j++)
				printf("%c", a[i]);
		printf("\n");
	}
}