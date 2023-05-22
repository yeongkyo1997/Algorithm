import sys
import math

MOD = 1000000007

def init(start, end, node):
    if start == end:
        tree[node] = arr[start]
        return tree[node]

    mid = (start + end) // 2

    tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD
    return tree[node]

def mul(start, end, node, left, right):
    if left > end or right < start:
        return 1

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % MOD

def update(start, end, node, idx, val):
    if idx < start or idx > end:
        return tree[node]

    if start == end:
        tree[node] = val
        return tree[node]

    mid = (start + end) // 2
    tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % MOD
    return tree[node]

input = sys.stdin.readline
N, M, K = map(int, input().split())

arr = [0] + [int(input()) for _ in range(N)]

tree = [0] * (N * 4)

init(1, N, 1)

result = []
for _ in range(M + K):
    a, b, c = map(int, input().split())

    if a == 1:
        arr[b] = c
        update(1, N, 1, b, c)
    elif a == 2:
        result.append(str(mul(1, N, 1, b, c)))

print('\n'.join(result))