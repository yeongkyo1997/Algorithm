#include <stdio.h>

int reverse(int n) {
	int sum = 0;
	while (n != 0) {
		sum += n % 10;
		sum *= 10;
		n /= 10;
	}
	return sum / 10;
}

int main() {
	int a, b;
	scanf("%d %d", &a, &b); 
	printf("%d", reverse(reverse(a) + reverse(b)));
}