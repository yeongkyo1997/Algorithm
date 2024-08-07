import collections
import copy

N, M, D = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
board.append([0] * M)
dir = [(-1, 0), (0, -1), (0, 1)]


# 적 이동
def down_board(board):
    for col in range(M):
        for row in range(N - 1, 0, -1):
            board[row][col] = board[row - 1][col]
            board[row - 1][col] = 0


# 궁수 배치
def batch(path, depth, start):
    global result
    if depth == 3:
        total = 0
        tmp = copy.deepcopy(board)
        for _ in range(N):
            kill = set()

            for p in path:
                x, y = kill_enemy(tmp, p)
                if x != -1:
                    kill.add((x, y))
            for x, y in kill:
                tmp[x][y] = 0
            total += len(kill)
            down_board(tmp)
        result = max(result, total)
        return

    for i in range(start, M):
        path.append((N, i))
        batch(path, depth + 1, i + 1)
        path.pop()


# 적 탐색(죽인 적의 좌표를 리턴)
def kill_enemy(board, arch):
    x, y = arch
    visited = [[False] * M for _ in range(N)]
    arr = []
    q = collections.deque()
    q.append((x, y, 0))

    while q:
        x, y, depth = q.popleft()

        if depth == D:
            break
        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, depth + 1))
                if board[nx][ny] == 1:
                    arr.append((depth + 1, nx, ny))
    if arr:
        arr.sort(key=lambda x: (x[0], x[2]))
        x, y = arr[0][1], arr[0][2]
        return x, y
    else:
        return -1, -1


result = 0
batch([], 0, 0)
print(result)