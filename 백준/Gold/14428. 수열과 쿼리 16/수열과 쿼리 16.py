import math
import sys

input = lambda: sys.stdin.readline().rstrip()


class Node:
    def __init__(self, min_val=math.inf, idx=math.inf):
        self.min_val = min_val
        self.idx = idx

    def __lt__(self, other):
        return (self.min_val, self.idx) < (other.min_val, other.idx)


def build(node, start, end):
    if start == end:
        tree[node] = Node(arr[start], start)
        return

    mid = (start + end) // 2

    build(node * 2, start, mid)
    build(node * 2 + 1, mid + 1, end)

    tree[node] = min(tree[node * 2], tree[node * 2 + 1])


def update(idx, val, node, start, end):
    if idx < start or end < idx:
        return

    if start == end:
        tree[node] = Node(val, start)
        return

    mid = (start + end) // 2

    update(idx, val, node * 2, start, mid)
    update(idx, val, node * 2 + 1, mid + 1, end)
    tree[node] = min(tree[node * 2], tree[node * 2 + 1])


def query(left, right, node, start, end):
    if right < start or end < left:
        return Node()

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2

    return min(query(left, right, node * 2, start, mid), query(left, right, node * 2 + 1, mid + 1, end))


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    M = int(input())
    tree = [Node() for _ in range(N * 4)]
    build(1, 0, N - 1)
    for _ in range(M):
        q, a, b = map(int, input().split())
        if q == 1:
            update(a - 1, b, 1, 0, N - 1)
        elif q == 2:
            print(query(a - 1, b - 1, 1, 0, N - 1).idx + 1)