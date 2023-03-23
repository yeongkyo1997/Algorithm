import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
q = collections.deque([i for i in range(1, n + 1)])
while len(q) > 1:
    q.popleft()
    q.append(q.popleft())
print(q[0])
