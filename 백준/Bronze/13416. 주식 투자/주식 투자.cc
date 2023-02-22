#include <stdio.h>

int main() {
  int input, testcase, answer[100000], cmp = 0, temp = 0, a;

  scanf("%d", &input);

  for (int i = 0; i < input; i++) {

	  scanf("%d", &testcase);

	  for (int j = 0; j < testcase; j++) {

		  for (int k = 0; k < 3; k++) {

			  scanf("%d", &a);

			  if (a > cmp)
				  cmp = a;
		  }
		  temp += cmp;
		  cmp = 0;
	  }
	  answer[i] = temp;
	  temp = 0;
  }

  for (int i = 0; i < input; i++) {
	  printf("%d\n", answer[i]);
  }
}