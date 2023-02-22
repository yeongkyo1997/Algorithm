#include<stdio.h>
#include<stdlib.h>
#define MAX_ARR_LEN 100001

int input[MAX_ARR_LEN] = { 0 };

void merge(int arr[], int startIdx, int midIdx, int endIdx) {
	int l = startIdx, r = midIdx + 1, cnt = 0;

	int* tmpArr = (int*)malloc(sizeof(int) * (endIdx - startIdx + 1));
	while (l <= midIdx && r <= endIdx) {
		if (arr[l] < arr[r])
			tmpArr[cnt++] = arr[l++];
		else
			tmpArr[cnt++] = arr[r++];
	}

	while (l <= midIdx)
		tmpArr[cnt++] = arr[l++];
	while (r <= endIdx)
		tmpArr[cnt++] = arr[r++];

	cnt = 0;
	for (int i = startIdx; i <= endIdx; i++) {
		arr[i] = tmpArr[cnt++];
	}
}

void merge_sort(int arr[], int startIdx, int endIdx) {
	if (startIdx < endIdx) {
		int midIdx = (startIdx + endIdx) / 2;
		merge_sort(arr, startIdx, midIdx);
		merge_sort(arr, midIdx + 1, endIdx);
		merge(arr, startIdx, midIdx, endIdx);
	}
}

int main(void) {
	int N;
	scanf("%d", &N);

	for (int i = 0; i < N; i++)
		scanf("%d", &input[i]);
	merge_sort(input, 0, N - 1);
	int prevVal = -2000;
	printf("%d ", input[0]);
	prevVal = input[0];
	for (int i = 1; i < N; i++) {
		if (prevVal == input[i])
			continue;
		else {
			printf("%d ", input[i]);
			prevVal = input[i];
		}
	}
}