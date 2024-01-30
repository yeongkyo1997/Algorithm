import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

arr = list(map(int, input().split()))
q = deque(list(range(1, N + 1)))
result = 0

for i in range(M):
    if q[0] == arr[i]:
        N -= 1
    elif q.index(arr[i]) < len(q) / 2:
        while q[0] != arr[i]:
            q.rotate(-1)
            result += 1
    else:
        while q[0] != arr[i]:
            q.rotate(1)
            result += 1
    q.popleft()

print(result)