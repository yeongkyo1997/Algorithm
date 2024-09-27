import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def build(node, start, end):
    if start == end:
        tree[node] = (start, arr[start])
        return

    mid = start + end >> 1
    build(node * 2, start, mid)
    build(node * 2 + 1, mid + 1, end)

    l_idx, l_val = tree[node * 2]
    r_idx, r_val = tree[node * 2 + 1]

    if l_val == r_val:
        tree[node] = (min(l_idx, r_idx), l_val)
    elif l_val > r_val:
        tree[node] = (r_idx, r_val)
    else:
        tree[node] = (l_idx, l_val)


def update(idx, val, node, start, end):
    if idx < start or end < idx:
        return

    if start == end:
        tree[node] = (idx, val)
        return

    mid = start + end >> 1
    update(idx, val, node * 2, start, mid)
    update(idx, val, node * 2 + 1, mid + 1, end)

    l_idx, l_val = tree[node * 2]
    r_idx, r_val = tree[node * 2 + 1]

    if l_val == r_val:
        tree[node] = (min(l_idx, r_idx), l_val)
    elif l_val > r_val:
        tree[node] = (r_idx, r_val)
    else:
        tree[node] = (l_idx, l_val)


def query(left, right, node, start, end):
    if right < start or end < left:
        return math.inf, math.inf

    if left <= start and end <= right:
        return tree[node]

    mid = start + end >> 1
    l_idx, l_val = query(left, right, node * 2, start, mid)
    r_idx, r_val = query(left, right, node * 2 + 1, mid + 1, end)

    if l_val == r_val:
        return min(l_idx, r_idx), l_val
    elif l_val > r_val:
        return r_idx, r_val
    else:
        return l_idx, l_val


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    M = int(input())
    tree = [(math.inf, math.inf) for _ in range(N * 4)]
    build(1, 0, N - 1)
    for _ in range(M):
        q, *data = map(int, input().split())

        if q == 1:
            i, v = data
            update(i - 1, v, 1, 0, N - 1)
        else:
            i, j = data
            print(query(i - 1, j - 1, 1, 0, N - 1)[0] + 1)