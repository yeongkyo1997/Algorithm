#include <stdio.h>



int main(){

	

	int num[10] = {0, }, el[42] = {0, }, i, cnt = 0, zero = 0;

	

	for(i = 0; i < 10; i++){

		

		scanf("%d", &num[i]);

		el[num[i] % 42]++;

		

		if(num[i] % 42 == 0)

			zero++;

	}

	

	for(i = 0; i < 42; i++){

		

		//printf("%d ", el[i]);

		if(el[i] > 0)

			cnt++;

	}

	

	printf("%d", cnt);
}