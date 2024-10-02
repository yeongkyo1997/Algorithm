import math
import sys


input = lambda: sys.stdin.readline().rstrip()
print = sys.stdout.write


class SegmentTree:
    def __init__(self, arr):
        self.arr = arr
        self.n = len(arr)
        self.tree = [0] * (4 * self.n)
        self.build(1, 0, self.n - 1)

    def build(self, node, start, end):
        if start == end:
            self.tree[node] = self.arr[start]
            return

        mid = start + end >> 1
        self.build(node * 2, start, mid)
        self.build(node * 2 + 1, mid + 1, end)
        self.tree[node] = min(self.tree[node * 2], self.tree[node * 2 + 1])

    def update(self, val, idx, node, start, end):
        if idx < start or end < idx:
            return

        if start == end:
            self.tree[node] = val
            return

        mid = start + end >> 1

        self.update(val, idx, node * 2, start, mid)
        self.update(val, idx, node * 2 + 1, mid + 1, end)
        self.tree[node] = min(self.tree[node * 2], self.tree[node * 2 + 1])

    def query(self, left, right, node, start, end):
        if right < start or end < left:
            return math.inf

        if left <= start and end <= right:
            return self.tree[node]

        mid = start + end >> 1

        return min(self.query(left, right, node * 2, start, mid), self.query(left, right, node * 2 + 1, mid + 1, end))


if __name__ == '__main__':
    N = int(input())
    arr = list(map(int, input().split()))
    seg = SegmentTree(arr)
    results = []

    for _ in range(int(input())):
        q, *data = map(int, input().split())

        if q == 1:
            i, v = data
            seg.update(v, i - 1, 1, 0, N - 1)
        elif q == 2:
            i, j = data
            results.append(seg.query(i - 1, j - 1, 1, 0, N - 1))

    print('\n'.join(map(str, results)))
