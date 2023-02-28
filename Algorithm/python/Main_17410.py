import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 17410 수열과 쿼리 1.5
# 세그먼트 트리
# https://www.acmicpc.net/problem/17410

tree = [0] * 262144
lazy = [0] * 262144


def update(node, start, end, left, right, diff):
    if lazy[node] != 0:
        tree[node] += (end - start + 1) * lazy[node]
        if start != end:
            lazy[node * 2] += lazy[node]
            lazy[node * 2 + 1] += lazy[node]
        lazy[node] = 0

    if start > right or end < left:
        return

    if left <= start and end <= right:
        tree[node] += (end - start + 1) * diff
        if start != end:
            lazy[node * 2] += diff
            lazy[node * 2 + 1] += diff
        return

    mid = (start + end) // 2
    update(node * 2, start, mid, left, right, diff)
    update(node * 2 + 1, mid + 1, end, left, right, diff)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]


def query(node, start, end, left, right):
    if lazy[node] != 0:
        tree[node] += (end - start + 1) * lazy[node]
        if start != end:
            lazy[node * 2] += lazy[node]
            lazy[node * 2 + 1] += lazy[node]
        lazy[node] = 0

    if start > right or end < left:
        return 0

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right)


def solution():
    n, m = map(int, input().split())
    for i in range(1, n + 1):
        update(1, 1, n, i, i, int(input()))

    for _ in range(m):
        a, b, c = map(int, input().split())
        if a == 1:
            update(1, 1, n, b, c, 1)
        else:
            print(query(1, 1, n, b, c))


solution()

