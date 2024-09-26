import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return

    mid = (start + end) // 2
    build(node * 2 + 1, start, mid)
    build(node * 2 + 2, mid + 1, end)
    tree[node] = min(tree[node * 2 + 1], tree[node * 2 + 2])

    return


def query(node, left, right, start, end):
    if right < start or end < left:
        return math.inf

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return min(query(node * 2 + 1, left, right, start, mid), query(node * 2 + 2, left, right, mid + 1, end))


if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = [int(input()) for _ in range(N)]
    tree = [0] * (N * 4)
    build(0, 0, N - 1)

    for _ in range(M):
        a, b = map(int, input().split())
        print(query(0, a - 1, b - 1, 0, N - 1))