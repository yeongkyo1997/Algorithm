import sys

input = lambda: sys.stdin.readline().rstrip()


def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]
    else:
        mid = (start + end) // 2
        tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
        return tree[node]


def query(node, start, end, left, right):
    if left > end or right < start:
        return 0

    if left <= start and end >= right:
        return tree[node]

    mid = (start + end) // 2
    tree[node] = query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right)
    return tree[node]


def update(node, start, end, idx, diff):
    if idx < start or idx > end:
        return
    if start == end:
        tree[node] += diff
        return tree[node]

    mid = (start + end) // 2
    tree[node] = update(node * 2, start, mid, idx, diff) + update(node * 2 + 1, mid + 1, end, idx, diff)

    return tree[node]

arr = []
tree = []

init(1,0,)