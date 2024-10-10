import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def set_group():
    def bfs(x, y, num):
        q = collections.deque()
        q.append((x, y))
        group[x][y] = num
        group_cnt[num] = 1
        while q:
            x, y = q.popleft()
            for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 0 and group[nx][ny] == 0:
                    group[nx][ny] = num
                    group_cnt[num] += 1
                    q.append((nx, ny))

    num = 1
    for i in range(N):
        for j in range(M):
            if board[i][j] == 0 and group[i][j] == 0:
                bfs(i, j, num)
                num += 1


def get_dist():
    def get_total(x, y):
        ret = 0
        visited = set()
        for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < M:
                num = group[nx][ny]
                if num in visited:
                    continue

                visited.add(num)
                ret += group_cnt[num]
        return ret

    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                board[i][j] = (board[i][j] + get_total(i, j)) % 10


if __name__ == '__main__':
    N, M = map(int, input().split())

    board = [list(map(int, input())) for _ in range(N)]
    group = [[0] * M for _ in range(N)]
    group_cnt = collections.defaultdict(int)

    set_group()
    get_dist()
    for b in board:
        print(''.join(map(str, b)))