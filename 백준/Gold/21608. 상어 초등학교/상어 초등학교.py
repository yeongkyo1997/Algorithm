import sys


def input(): return sys.stdin.readline().rstrip()


def seat(N, preferences, student):
    a, b = -1, -1
    ret = None
    for i in range(N):
        for j in range(N):
            if room[i][j] == 0:
                like, empty = 0, 0
                for dx, dy in d:
                    nx, ny = i + dx, j + dy
                    if 0 <= nx < N and 0 <= ny < N:
                        if room[nx][ny] in preferences[student]:
                            like += 1
                        elif room[nx][ny] == 0:
                            empty += 1

                if (like, empty) > (a, b):
                    a, b = like, empty
                    ret = (i, j)

    return ret


def solution(N, prefer):
    ret = 0
    for i in range(N):
        for j in range(N):
            student = room[i][j]
            like = sum(1 for dx, dy in d if 0 <= i + dx < N and 0 <=
                       j + dy < N and room[i + dx][j + dy] in prefer[student])
            if like:
                ret += 10 ** (like - 1)
    return ret


d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

N = int(input())
preferences = {}
for _ in range(N ** 2):
    student, *like = map(int, input().split())
    preferences[student] = like

room = [[0] * N for _ in range(N)]

for student in preferences:
    x, r = seat(N, preferences, student)
    room[x][r] = student

print(solution(N, preferences))