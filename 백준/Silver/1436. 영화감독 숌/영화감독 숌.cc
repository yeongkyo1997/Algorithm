#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int endNum(char str[]) {
	int size = strlen(str);
	int count = 0;
	int i;
	int j;

	for (i = size - 1; i >= 0; i--) {
		count = 0;
		if (str[i] == '6')
			for (j = i; j > j - 3 && str[j] != '\0'; j--) {
				if (str[j] == '6')
					count++;
				else
					count = 0;
				if (count == 3)
					return 1;
			}
	}
	return 0;
}

int main() {
	int count = 0;
	int n;
	int i;
	scanf("%d", &n);

	for (i = 1; i <= 10000000; i++) {
		char str[10001];
		sprintf(str, "%d", i);
		if (endNum(str) == 1) {
			if (++count == n) {
				printf("%s", str);
				break;
			}
		}
	}
}