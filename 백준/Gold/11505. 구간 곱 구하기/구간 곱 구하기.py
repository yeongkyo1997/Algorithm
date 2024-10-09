import sys


MOD = 1_000_000_007

input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = arr[start] % MOD
        return

    mid = start + end >> 1

    build(node * 2, start, mid)
    build(node * 2 + 1, mid + 1, end)

    tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD


def update(val, idx, node, start, end):
    if idx < start or end < idx:
        return

    if start == end:
        tree[node] = val
        return

    mid = start + end >> 1

    update(val, idx, node * 2, start, mid)
    update(val, idx, node * 2 + 1, mid + 1, end)
    tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD


def query(left, right, node, start, end):
    if right < start or end < left:
        return 1

    if left <= start and end <= right:
        return tree[node]

    mid = start + end >> 1

    return (query(left, right, node * 2, start, mid) * query(left, right, node * 2 + 1, mid + 1, end)) % MOD


if __name__ == '__main__':
    N, M, K = map(int, input().split())

    arr = [int(input()) for _ in range(N)]
    tree = [1] * (4 * N)
    build(1, 0, N - 1)

    for _ in range(M + K):
        q, *data = map(int, input().split())

        if q == 1:
            b, c = data
            update(c, b - 1, 1, 0, N - 1)
        elif q == 2:
            b, c = data
            print(query(b - 1, c - 1, 1, 0, N - 1) % MOD)