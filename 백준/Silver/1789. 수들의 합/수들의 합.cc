#include <stdio.h>

int main() {
	long long int n;
	long long int count = 0;
	scanf("%lld", &n);
	
	for (int i = 1 ; i <= n; i++) {
		
		n -= i;
		count++;
	}
			printf("%d", count);		
}