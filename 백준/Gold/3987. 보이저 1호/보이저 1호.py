import collections
import math

dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
N, M = map(int, input().rstrip().split())
board = [list(input().rstrip()) for _ in range(N)]
result = collections.defaultdict(lambda: 1)
direction = ['U', 'R', 'D', 'L']


def move(x, y, d):
    result = 0
    nx, ny = x, y

    while True:
        if result > 500 ** 2 * 2:
            return math.inf
        dx, dy = dir[d]
        nx += dx
        ny += dy

        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            break
        if board[nx][ny] == 'C':
            break
        if board[nx][ny] == '/':
            if d % 2 == 0:
                d = (d + 1) % 4
            else:
                d = (d - 1) % 4
        elif board[nx][ny] == '\\':
            if d % 2 == 0:
                d = (d - 1) % 4
            else:
                d = (d + 1) % 4
        result += 1

    return result


x, y = map(int, input().rstrip().split())
for i in range(4):
    result[i] += move(x - 1, y - 1, i)

max_val = max(result.values())

for key, val in result.items():
    if val == max_val:
        print(direction[key])
        if max_val == math.inf:
            print('Voyager')
        else:
            print(max_val)
        break