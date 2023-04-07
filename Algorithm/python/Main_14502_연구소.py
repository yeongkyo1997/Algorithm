import copy
import sys
from collections import deque

input = sys.stdin.readline

dir = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def bfs():
    global result

    queue = deque()

    test_map = copy.deepcopy(arr)
    for i in range(n):
        for k in range(m):
            if test_map[i][k] == 2:
                queue.append((i, k))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            dx = x + dir[i][0]
            dy = y + dir[i][1]

            if (0 <= dx < n) and (0 <= dy < m) and test_map[dx][dy] == 0:
                test_map[dx][dy] = 2
                queue.append((dx, dy))

    count = 0

    for i in range(n):
        for k in range(m):
            if test_map[i][k] == 0:
                count += 1

    result = max(result, count)


def make_wall(cnt):
    if cnt == 3:
        bfs()
        return

    for i in range(n):
        for k in range(m):
            if arr[i][k] == 0:
                arr[i][k] = 1
                make_wall(cnt + 1)
                arr[i][k] = 0


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

result = 0
make_wall(0)

print(result)
