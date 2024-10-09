import sys


input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return

    mid = start + end >> 1

    build(node * 2, start, mid)
    build(node * 2 + 1, mid + 1, end)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]


def propagation(node, start, end):
    if lazy[node] != 0:
        tree[node] += (end - start + 1) * lazy[node]

        if start != end:
            lazy[node * 2] += lazy[node]
            lazy[node * 2 + 1] += lazy[node]

        lazy[node] = 0


def update(left, right, val, node, start, end):
    propagation(node, start, end)
    if right < start or end < left:
        return

    if left <= start and end <= right:
        tree[node] += (end - start + 1) * val

        if start != end:
            lazy[node * 2] += val
            lazy[node * 2 + 1] += val
        return

    mid = start + end >> 1

    update(left, right, val, node * 2, start, mid)
    update(left, right, val, node * 2 + 1, mid + 1, end)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]


def query(left, right, node, start, end):
    propagation(node, start, end)
    if right < start or end < left:
        return 0

    if left <= start and end <= right:
        return tree[node]

    mid = start + end >> 1
    return query(left, right, node * 2, start, mid) + query(left, right, node * 2 + 1, mid + 1, end)


if __name__ == '__main__':
    N, M, K = map(int, input().split())

    arr = [int(input()) for _ in range(N)]
    tree = [0] * (4 * N)
    lazy = [0] * (4 * N)
    build(1, 0, N - 1)

    for _ in range(M + K):
        q, *data = map(int, input().split())

        if q == 1:
            b, c, d = data
            update(b - 1, c - 1, d, 1, 0, N - 1)
        elif q == 2:
            b, c = data
            print(query(b - 1, c - 1, 1, 0, N - 1))