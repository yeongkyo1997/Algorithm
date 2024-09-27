import sys

input = lambda: sys.stdin.readline().rstrip()


class FenwickTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (n + 1)

    def update(self, idx, delta):
        while idx <= self.n:
            self.tree[idx] += delta
            idx += idx & -idx

    def prefix_sum(self, idx):
        result = 0
        while idx > 0:
            result += self.tree[idx]
            idx -= idx & -idx
        return result

    def range_sum(self, left, right):
        return self.prefix_sum(right) - self.prefix_sum(left - 1)


N, M = map(int, input().split())
fenwick = FenwickTree(N)
A = [0] * (N + 1)

for _ in range(M):
    command = list(map(int, input().split()))
    if command[0] == 1:
        # Modify(i, k): A[i] = k
        i, k = command[1], command[2]
        delta = k - A[i]
        A[i] = k
        fenwick.update(i, delta)
    else:
        # Sum(i, j): 구간 합을 계산
        i, j = command[1], command[2]
        if i > j:
            i, j = j, i
        print(fenwick.range_sum(i, j))