#include <stdio.h>

int main() {
	int arr[10];
	int a, b, c;
	int i;
	int n;
	
	scanf("%d %d %d", &a, &b, &c);
	
	for (i = 0; i < 10; i++) {
		arr[i] = 0;
	}
	
	n = a * b * c;
	
	while (n != 0) {
		  arr[n % 10]++;
		  n /= 10;
	}
	
	for (i = 0; i < sizeof(arr) / sizeof(int); i++) {
		printf("%d\n", arr[i]);
	}
}