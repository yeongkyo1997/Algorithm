#include<stdio.h>

int main() {
	char c1[100001], c2[100001];

	int T;

	scanf("%d", &T);

	while (T--) {
		int N;

		scanf("%d", &N);
		scanf("%s", c1);
		scanf("%s", c2);

		int wbCnt = 0, bwCnt = 0;
		for (int i = 0; i < N; ++i) {
			if (c1[i] == 'W' && c2[i] == 'B')
				++wbCnt;
			else if (c1[i] == 'B' && c2[i] == 'W')
				++bwCnt;
		}
		printf("%d\n", wbCnt < bwCnt ? bwCnt : wbCnt);
	}
}