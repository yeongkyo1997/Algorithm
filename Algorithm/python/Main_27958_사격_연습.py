import copy
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
K = int(input())
MAP = [list(map(int, input().split())) for _ in range(N)]
bullets = list(map(int, input().split()))
MAX = 0


def perm(cnt, score, COPY, init_hp):
    global MAX
    if cnt == K:
        if MAX < score:
            MAX = score
        return

    for j in range(N):
        new_map = copy.deepcopy(COPY)
        new_hp = copy.deepcopy(init_hp)
        perm(cnt + 1, score + shoot(j, cnt, new_map, new_hp), new_map, new_hp)


def shoot(x, bullet, new_map, new_hp):
    get_score = 0

    for y in range(N):
        if new_map[x][y] == 0:
            continue

        if new_map[x][y] < 10:
            new_map[x][y] -= bullets[bullet]

            if new_map[x][y] <= 0:
                get_score = new_hp[x][y]
                new_map[x][y] = 0

                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]

                    if (0 > nx or nx >= N) or (0 > ny or ny >= N) or new_map[nx][ny] != 0:
                        continue
                    new_map[nx][ny] = new_hp[x][y] // 4
                    new_hp[nx][ny] = new_map[nx][ny]
            return get_score

        if new_map[x][y] >= 10:
            get_score = new_map[x][y]
            new_map[x][y] = 0
            new_hp[x][y] = 0
            return get_score
    return get_score


dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
perm(0, 0, MAP, MAP)
print(MAX)
