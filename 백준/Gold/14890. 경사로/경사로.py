import sys


def input(): return sys.stdin.readline().rstrip()


N, L = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]


def check(road):
    used = [False] * N
    for i in range(1, N):
        if abs(road[i] - road[i - 1]) > 1:
            return False
        else:
            if road[i] < road[i - 1]:
                for j in range(L):
                    if i + j >= N or used[i + j] or road[i + j] != road[i]:
                        return False
                    if road[i] == road[i + j]:
                        used[i + j] = True
            elif road[i] > road[i - 1]:
                for j in range(1, L + 1):
                    if i - j < 0 or used[i - j] or road[i - j] != road[i - 1]:
                        return False
                    if road[i - 1] == road[i - j]:
                        used[i - j] = True

    return True


result = 0
for road in board:
    if check(road):
        result += 1

for i in range(N):
    road = [board[j][i] for j in range(N)]
    if check(road):
        result += 1

print(result)