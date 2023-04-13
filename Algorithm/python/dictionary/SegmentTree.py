import sys

input = lambda: sys.stdin.readline().rstrip()


def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]
    else:
        mid = (start + end) // 2
        tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end)
        return tree[node]


def query(node, start, end, left, right):
    if left > end or start > right:
        return 0

    if left <= start and end >= right:
        return tree[node]

    mid = (start + end) // 2
    return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right)


def update(node, start, end, idx, diff):
    if idx < start or idx > end:
        return

    tree[node] += diff

    mid = (start + end) // 2
    if start != end:
        update(node * 2, start, mid, idx, diff)
        update(node * 2 + 1, mid + 1, end, idx, diff)


n, m, k = map(int, input().rstrip().split())

arr = []
tree = [0] * 3000000

for _ in range(n):
    arr.append(int(input().rstrip()))

init(1, 0, n - 1)

for _ in range(m + k):
    a, b, c = map(int, input().rstrip().split())

    if a == 1:
        b = b - 1
        diff = c - arr[b]
        arr[b] = c
        update(1, 0, n - 1, b, diff)
    elif a == 2:
        print(query(1, 0, n - 1, b - 1, c - 1))
