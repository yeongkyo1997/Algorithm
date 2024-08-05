import collections
import math

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N, M = map(int, input().rstrip().split())
board = [list(map(int, input().rstrip().split())) for _ in range(N)]

visited = [[False] * M for _ in range(N)]


# 섬에 번호 부여하기
def bfs(x, y, num):
    board[x][y] = num
    q = collections.deque()
    q.append((x, y))

    while q:
        x, y = q.popleft()

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and board[nx][ny] == 1:
                visited[nx][ny] = True
                board[nx][ny] = num
                q.append((nx, ny))


num = 1
for i in range(N):
    for j in range(M):
        if not visited[i][j] and board[i][j] == 1:
            bfs(i, j, num)
            num += 1

connected = []


# 섬 연결하기
def connect_island(x, y, num):
    for dx, dy in dir:
        length = 0
        nx, ny = x, y

        while True:
            nx += dx
            ny += dy

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                break
            if 0 < board[nx][ny] <= num:
                break

            if board[nx][ny] > num:
                if length >= 2:
                    connected.append((length, num, board[nx][ny]))
                    break
                else:
                    break
            length += 1


for i in range(N):
    for j in range(M):
        if board[i][j] > 0:
            connect_island(i, j, board[i][j])

parent = [i for i in range(num)]
rank = [0] * num


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if rank[a] > rank[b]:
        parent[b] = a
    elif rank[a] < rank[b]:
        parent[a] = b
    else:
        parent[b] = a
        rank[a] += 1


result = []
connected.sort()
for dist, a, b in connected:
    if find(a) != find(b):
        union(a, b)
        result.append(dist)

if len(result) == num - 2:
    print(sum(result))
else:
    print(-1)