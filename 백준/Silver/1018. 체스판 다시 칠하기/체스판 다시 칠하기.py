import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())

board = [input() for _ in range(N)]
result = []


for i in range(N - 7):
    for j in range(M - 7):
        st1, st2 = 0, 0

        for x in range(i, i + 8):
            for y in range(j, j + 8):
                if (x + y) % 2 != 0:
                    if board[x][y] == 'W':
                        st1 += 1
                    else:
                        st2 += 1
                else:
                    if board[x][y] == 'B':
                        st1 += 1
                    else:
                        st2 += 1

        result.append(st1)
        result.append(st2)
print(min(result))