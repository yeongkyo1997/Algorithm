import sys

input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return

    mid = (start + end) // 2

    build(node * 2 + 1, start, mid)
    build(node * 2 + 2, mid + 1, end)
    tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2]


def update(idx, val, node, start, end):
    if idx < start or end < idx:
        return
    if start == end:
        tree[node] = val
    else:
        mid = (start + end) // 2
        update(idx, val, node * 2 + 1, start, mid)
        update(idx, val, node * 2 + 2, mid + 1, end)
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2]


def query(left, right, node, start, end):
    if right < start or end < left:
        return 0

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2

    return query(left, right, node * 2 + 1, start, mid) + query(left, right, node * 2 + 2, mid + 1, end)


if __name__ == '__main__':
    N, M, K = map(int, input().split())
    arr = [int(input()) for _ in range(N)]
    tree = [0] * (N * 4)
    build(0, 0, N - 1)

    for _ in range(M + K):
        a, b, c = map(int, input().split())
        if a == 1:
            update(b - 1, c, 0, 0, N - 1)
        else:
            print(query(b - 1, c - 1, 0, 0, N - 1))