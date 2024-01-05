import sys
from collections import deque


def input(): return sys.stdin.readline().strip()


test_case = int(input())

for _ in range(test_case):
    q = deque()
    n, m = map(int, input().split())
    important = list(map(int, input().split()))

    [q.append((idx, val)) for idx, val in enumerate(important)]

    result = 1
    while q:
        idx, val = q[0]

        if all(val >= i[1] for i in q):
            if idx == m:
                print(result)
                break
            else:
                result += 1
                q.popleft()
        else:
            q.rotate(-1)