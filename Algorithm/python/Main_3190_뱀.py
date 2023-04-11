import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
K = int(input())
apple = []
visited = [[False] * N for _ in range(N)]

for _ in range(K):
    apple.append(list(map(int, input().split())))
    visited[apple[-1][0] - 1][apple[-1][1] - 1] = True

L = int(input())
direction = []

for _ in range(L):
    direction.append(list(input().split()))
    direction[-1][0] = int(direction[-1][0])

snake = [[0, 0]]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def move():
    global snake, direction, visited, N

    time = 0
    idx = 0
    direction_idx = 0
    while True:
        time += 1
        x, y = snake[-1][0] + dx[idx], snake[-1][1] + dy[idx]

        if x < 0 or x >= N or y < 0 or y >= N:
            break
        elif [x, y] in snake:
            break
        else:
            snake.append([x, y])

            if visited[x][y]:
                visited[x][y] = False
            else:
                snake.pop(0)

        if direction_idx < len(direction) and time == direction[direction_idx][0]:
            if direction[direction_idx][1] == 'D':
                idx = (idx + 1) % 4
            else:
                idx = (idx - 1) % 4
            direction_idx += 1

    return time


print(move())
