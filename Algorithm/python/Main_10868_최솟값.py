import math
import sys

input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())

arr = [int(input()) for _ in range(N)]

tree = [0] * (4 * N)


def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]

    mid = (start + end) // 2

    tree[node] = min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end))
    return tree[node]


def query(node, start, end, left, right):
    if left > end or right < start:
        return math.inf
    elif left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return min(query(node * 2, start, mid, left, right), query(node * 2 + 1, mid + 1, end, left, right))


init(1, 0, N - 1)

for i in range(M):
    left, right = map(int, input().split())

    print(query(1, 0, N - 1, left - 1, right - 1))