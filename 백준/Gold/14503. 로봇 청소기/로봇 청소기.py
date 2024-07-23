N, M = map(int, input().rstrip().split())
r, c, d = map(int, input().rstrip().split())

board = [list(map(int, input().rstrip().split())) for _ in range(N)]
visited = set()
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
result = 0

# check
def check(x, y):
    if x < 0 or y < 0 or x >= N or y >= M:
        return False

    if board[x][y] == 1:
        return False

    return True

def move(x, y, d):
    global result

    while True:
        if (x, y) not in visited:
            result += 1
            visited.add((x, y))

        for _ in range(4):
            d = (d + 3) % 4
            nx, ny = x + dx[d], y + dy[d]

            if check(nx, ny) and (nx, ny) not in visited:
                x, y = nx, ny
                break
        else:
            nx, ny = x - dx[d], y - dy[d]
            if board[nx][ny] == 1:
                break
            x, y = nx, ny

move(r, c, d)
print(result)