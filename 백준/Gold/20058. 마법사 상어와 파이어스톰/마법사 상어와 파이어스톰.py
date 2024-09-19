import sys

sys.setrecursionlimit(10000)


# 얼음 자르기
def split(row, col, size, L):
    if 1 << L == size:
        tmp = [[0] * size for _ in range(size)]
        for i in range(size):
            for j in range(size):
                tmp[j][size - i - 1] = board[i + row][j + col]

        for i in range(size):
            for j in range(size):
                board[i + row][j + col] = tmp[i][j]
        return

    mid = size // 2

    # 1 사분면
    split(row, col + mid, mid, L)

    # 2 사분면
    split(row, col, mid, L)

    # 3 사분면
    split(row + mid, col, mid, L)

    # 4 사분면
    split(row + mid, col + mid, mid, L)


# 얼음 녹이기
def melting():
    tmp = [b[:] for b in board]
    for x in range(size):
        for y in range(size):
            if board[x][y] == 0:
                continue
            cnt = 0
            for dx, dy in dir:
                nx, ny = x + dx, y + dy

                if 0 <= nx < size and 0 <= ny < size and board[nx][ny] > 0:
                    cnt += 1
            if cnt < 3:
                tmp[x][y] -= 1

    return tmp


def get_clust(N):
    def dfs(x, y):
        if visited[x][y]:
            return 0

        visited[x][y] = True
        result = 1
        for dx, dy in dir:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and board[nx][ny] != 0:
                result += dfs(nx, ny)
        return result

    visited = [[False] * N for _ in range(N)]

    ret = 0
    for x in range(N):
        for y in range(N):
            if visited[x][y] or board[x][y] == 0:
                continue

            ret = max(ret, dfs(x, y))

    return ret


if __name__ == '__main__':
    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    N, Q = map(int, input().split())
    size = 1 << N
    board = [list(map(int, input().split())) for _ in range(size)]

    query = list(map(int, input().split()))

    for L in query:
        split(0, 0, size, L)
        board = melting()

    # 얼음의 합
    print(sum(sum(b) for b in board))
    print(get_clust(size))