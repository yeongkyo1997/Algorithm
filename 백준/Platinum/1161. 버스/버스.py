import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    K, N, C = map(int, input().split())
    groups = []
    for _ in range(K):
        S, E, M = map(int, input().split())
        groups.append((E, S, M))

    groups.sort()


    class SegmentTree:
        def __init__(self, size):
            self.N = 1
            while self.N < size:
                self.N <<= 1
            self.size = self.N
            self.maxv = [0] * (2 * self.N)
            self.lazy = [0] * (2 * self.N)

        def push(self, node):
            if self.lazy[node] != 0:
                self.maxv[node] += self.lazy[node]
                if node < self.N:
                    self.lazy[node * 2] += self.lazy[node]
                    self.lazy[node * 2 + 1] += self.lazy[node]
                self.lazy[node] = 0

        def range_add(self, l, r, val, node=1, node_left=0, node_right=None):
            if node_right is None:
                node_right = self.N - 1
            self.push(node)
            if r < node_left or node_right < l:
                return
            if l <= node_left and node_right <= r:
                self.lazy[node] += val
                self.push(node)
                return
            mid = (node_left + node_right) // 2
            self.range_add(l, r, val, node * 2, node_left, mid)
            self.range_add(l, r, val, node * 2 + 1, mid + 1, node_right)
            self.maxv[node] = max(self.maxv[node * 2], self.maxv[node * 2 + 1])

        def range_max(self, l, r, node=1, node_left=0, node_right=None):
            if node_right is None:
                node_right = self.N - 1
            self.push(node)
            if r < node_left or node_right < l:
                return -1
            if l <= node_left and node_right <= r:
                return self.maxv[node]
            mid = (node_left + node_right) // 2
            return max(self.range_max(l, r, node * 2, node_left, mid),
                       self.range_max(l, r, node * 2 + 1, mid + 1, node_right))


    seg = SegmentTree(N)
    total = 0
    for E, S, M in groups:
        l = S - 1
        r = E - 2
        if l > r:
            continue
        cur_max = seg.range_max(l, r)
        available = C - cur_max
        take = min(M, available)
        if take > 0:
            total += take
            seg.range_add(l, r, take)
    print(total)