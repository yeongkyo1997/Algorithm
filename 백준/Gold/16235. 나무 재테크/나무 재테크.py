import copy

dir = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
N, M, K = map(int, input().split())

board = [[5] * N for _ in range(N)]
add_board = [list(map(int, input().split())) for _ in range(N)]
trees = [[list() for _ in range(N)] for _ in range(N)]

for _ in range(M):
    x, y, year = map(int, input().split())
    trees[x - 1][y - 1].append(year)


def spring():
    for i in range(N):
        for j in range(N):
            if trees[i][j]:
                trees[i][j].sort()

                del_list = []
                for t in range(len(trees[i][j])):
                    if board[i][j] >= trees[i][j][t]:
                        board[i][j] -= trees[i][j][t]
                        trees[i][j][t] += 1
                    else:
                        del_list.append(t)
                for d in del_list[::-1]:
                    board[i][j] += trees[i][j][d] // 2
                    del trees[i][j][d]


def fall():
    for i in range(N):
        for j in range(N):
            if trees[i][j]:
                for t in trees[i][j]:
                    if t % 5 == 0:
                        for dx, dy in dir:
                            nx, ny = i + dx, j + dy

                            if 0 <= nx < N and 0 <= ny < N:
                                trees[nx][ny].append(1)


def winter():
    for i in range(N):
        for j in range(N):
            board[i][j] += add_board[i][j]


for _ in range(K):
    spring()
    fall()
    winter()

result = 0
for i in range(N):
    for j in range(N):
        for t in trees[i][j]:
            if t != 0:
                result += 1

print(result)
