#include<stdio.h>
#define FOR(i,j) for(int i=1;i<=j;i++)
#define MAX 1001
int main() {
	int N, M;
	int queue[MAX] = { 0, };
	int adj[MAX] = { 0, };
	int front, back;

	FOR(i, MAX-1) {
		queue[i] = i;
	}

	scanf("%d %d", &N, &M);
	front = 1, back = N;
	FOR(i, N) {
		FOR(j, M-1) {
			back %= N;
			back++;
			queue[back] = queue[front];
			front %= N;
			front++;
		}
		adj[i] = queue[front];
		front %= N;
		front++;
	}
	printf("<");
	FOR(i, N - 1)
		printf("%d, ", adj[i]);
	printf("%d>", adj[N]);
}