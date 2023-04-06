import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, M, K = map(int, input().split())
arr = [int(input()) for _ in range(N)]
tree = [0] * (N * 4)


def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]
    mid = (start + end) // 2
    tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end)
    return tree[node]


def sum(node, start, end, left, right):
    if left > end or right < start:
        return 0
    if left <= start and end <= right:
        return tree[node]
    mid = (start + end) // 2
    return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right)


def update(node, start, end, idx, diff):
    if idx < start or idx > end:
        return
    tree[node] += diff
    if start == end:
        return
    mid = (start + end) // 2
    update(node * 2, start, mid, idx, diff)
    update(node * 2 + 1, mid + 1, end, idx, diff)


init(1, 0, N - 1)
for _ in range(M + K):
    arr, b, c = map(int, input().split())
    if arr == 1:
        diff = c - arr[b - 1]
        arr[b - 1] = c
        update(1, 0, N - 1, b - 1, diff)
    else:
        print(sum(1, 0, N - 1, b - 1, c - 1))
