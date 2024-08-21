import math


def invert(x):
    if x == 0:
        return 0
    elif x < 0:
        return -1
    else:
        return 1


def make_segment_tree(node, start, end):
    if start == end:
        segment_tree[node] = invert(arr[start])
        return segment_tree[node]

    mid = (start + end) // 2
    left_result = make_segment_tree(node * 2, start, mid)
    right_result = make_segment_tree(node * 2 + 1, mid + 1, end)

    segment_tree[node] = invert(left_result * right_result)
    return segment_tree[node]


def update(node, start, end, idx, value):
    if idx < start or idx > end:
        return segment_tree[node]
    if start == end:
        segment_tree[node] = invert(value)
        return segment_tree[node]

    mid = (start + end) // 2
    left_result = update(node * 2, start, mid, idx, value)
    right_result = update(node * 2 + 1, mid + 1, end, idx, value)

    segment_tree[node] = invert(left_result * right_result)
    return segment_tree[node]


def query(node, start, end, left, right):
    if right < start or left > end:
        return 1
    if left <= start and end <= right:
        return segment_tree[node]

    mid = (start + end) // 2
    left_result = query(node * 2, start, mid, left, right)
    right_result = query(node * 2 + 1, mid + 1, end, left, right)
    return invert(left_result * right_result)


def solve():
    global arr, segment_tree

    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    cmd = []
    answer = []

    tree_height = int(math.ceil(math.log2(n)))
    tree_size = (1 << (tree_height + 1))
    segment_tree = [0] * tree_size

    make_segment_tree(1, 0, n - 1)

    for _ in range(k):
        c, a, b = input().split()
        a, b = int(a), int(b)
        cmd.append((c, (a, b)))

    for c, (a, b) in cmd:
        if c == 'C':
            update(1, 0, n - 1, a - 1, b) 
        else:
            result = query(1, 0, n - 1, a - 1, b - 1)
            answer.append('0' if result == 0 else '-' if result < 0 else '+')

    print(''.join(answer))


while True:
    try:
        solve()
    except EOFError:
        break