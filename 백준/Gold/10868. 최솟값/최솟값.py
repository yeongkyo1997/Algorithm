import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = arr[start]
    else:
        mid = (start + end) // 2
        build(node * 2 + 1, start, mid)
        build(node * 2 + 2, mid + 1, end)
        tree[node] = min(tree[node * 2 + 1], tree[node * 2 + 2])


def query(node, start, end, left, right):
    # 범위 밖이라면
    if right < start or end < left:
        return math.inf

    # 전체가 범위 안이라면
    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return min(query(node * 2 + 1, start, mid, left, right), query(node * 2 + 2, mid + 1, end, left, right))


if __name__ == '__main__':
    N, M = map(int, input().split())
    arr = [int(input()) for _ in range(N)]
    tree = [math.inf] * (4 * N)
    build(0, 0, N - 1)
    for _ in range(M):
        a, b = map(int, input().split())
        print(query(0, 0, N - 1, a - 1, b - 1))