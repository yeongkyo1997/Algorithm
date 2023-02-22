#include <cstdio>
#include <iostream>

typedef long long int ll;
int n, m, k;
ll arr[1000001];
ll tree[3000100];

ll makeTree(int left, int right, int node) {

	if (left == right) {
		return tree[node] = arr[left];
	}

	int mid = (left + right) / 2;

	tree[node] += makeTree(left, mid, node * 2);
	tree[node] += makeTree(mid + 1, right, node * 2 + 1);

	return tree[node];
}

void upDate(int left, int right, int node, int change_node, ll diff) {

	if (!(left <= change_node && change_node <= right))
		return;

	tree[node] += diff;

	if (left != right) {
		int mid = (left + right) / 2;
		upDate(left, mid, node * 2, change_node, diff);
		upDate(mid + 1, right, node * 2 + 1, change_node, diff);
	}
}

ll sum(int node, int left, int right, int start, int end) {
	if (right < start || end < left)
		return 0;

	if (start <= left && right <= end)
		return tree[node];

	int mid = (left + right) / 2;

	return sum(node * 2, left, mid, start, end) + sum(node * 2 + 1, mid + 1, right, start, end);
}
int main() {
	scanf("%d %d %d", &n, &m, &k);
	for (int i = 1; i <= n; i++)
		scanf("%lld", &arr[i]);


	makeTree(1, n, 1);

	for (int i = 0; i < k + m; i++) {
		int cmd, b; ll c;
		scanf("%d %d %lld", &cmd, &b, &c);

		if (cmd == 1) {
			ll diff = c - arr[b];
			arr[b] = c;
			upDate(1, n, 1, b, diff);
		}
		else {
			printf("%lld\n", sum(1, 1, n, b, c));
		}
	}
}