#include <iostream>
#include <cstdio>
#include <cstdlib>

int main() {
	char ch[101];
	char* str;
	str = &(ch[0]);
	scanf("%s", &ch);
	int count = 0;

	while (true) {
		printf("%c", *str);
		str++;
		if (*str == NULL)
			break;
		count++;
		if (count == 10) {
			printf("\n");
			count = 0;
			continue;
		}

	}

}