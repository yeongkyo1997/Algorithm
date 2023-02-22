#include <stdio.h>

int main() {
	int input, i, j, k;

	scanf("%d", &input);
	
	for(i = 1; i <= input; i++) {
		for(k = 2; k <= i; k++) {
			printf(" ");
		}
		
		for(j = (input * 2 + 1) - (i * 2); j >= 1; j--) {
			printf("*");
		}
		printf("\n");
	}
	for(i = 1; i <= input - 1; i++) {
		for(k = input - 2; k >= i; k--) {
			printf(" ");
		}
		
		for(j = 1 + (i * 2); j >= 1; j--) {
			printf("*");
		}
		printf("\n");
	}
}

