import sys

input = lambda: sys.stdin.readline().rstrip()
print = sys.stdout.write


class SegmentTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.tree = [0] * (4 * self.n)
        self.arr = arr
        self.build(1, 0, self.n - 1)

    def build(self, node, start, end):
        if start == end:
            self.tree[node] = self.arr[start]
            return

        mid = start + end >> 1

        self.build(node * 2, start, mid)
        self.build(node * 2 + 1, mid + 1, end)
        self.tree[node] = self.tree[node * 2] + self.tree[node * 2 + 1]

    def update(self, val, idx, node, start, end):
        if idx < start or end < idx:
            return

        if start == end:
            self.tree[node] = val
            return

        mid = start + end >> 1
        self.update(val, idx, node * 2, start, mid)
        self.update(val, idx, node * 2 + 1, mid + 1, end)

        self.tree[node] = self.tree[node * 2] + self.tree[node * 2 + 1]

    def query(self, left, right, node, start, end):
        if right < start or end < left:
            return 0

        if left <= start and end <= right:
            return self.tree[node]

        mid = start + end >> 1

        return self.query(left, right, node * 2, start, mid) + self.query(left, right, node * 2 + 1, mid + 1, end)


if __name__ == '__main__':
    N, Q = map(int, input().split())
    arr = list(map(int, input().split()))
    seg = SegmentTree(arr)
    results = []

    for _ in range(Q):
        x, y, a, b = map(int, input().split())
        x, y = min(x, y), max(x, y)
        results.append(seg.query(x - 1, y - 1, 1, 0, N - 1))
        seg.update(b, a - 1, 1, 0, N - 1)

    print('\n'.join(map(str, results)))