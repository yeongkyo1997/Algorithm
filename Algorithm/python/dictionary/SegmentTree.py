data = []
tree = [0] * 3000000


def init(node, start, end):
    if start == end:
        tree[node] = data[start]
        return tree[node]
    else:
        mid = (start + end) // 2
        tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end)
        return tree[node]


def subSum(node, start, end, left, right):
    if left > end or right < start:
        return 0
    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    return subSum(node * 2, start, mid, left, right) + subSum(node * 2 + 1, mid + 1, end, left, right)


def update(node, start, end, idx, diff):
    if idx < start or idx > end:
        return

    tree[node] += diff

    if start != end:
        update(node * 2, start, (start + end) // 2, idx, diff)
        update(node * 2 + 1, start, (start + end) // 2, idx, diff)
