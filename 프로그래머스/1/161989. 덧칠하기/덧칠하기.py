from collections import deque


def solution(n, m, section):
    result = 0

    q = deque(section)

    for i in range(1, n + 1):
        if q and q[0] == i:
            for j in range(i, i + m):
                if q and q[0] <= j:
                    q.popleft()
            result += 1

    return result
