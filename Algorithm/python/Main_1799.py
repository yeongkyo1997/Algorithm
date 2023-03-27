import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
chess = []
for i in range(N):
    chess.append(list(map(int, input().split())))
result = [0, 0]
left = [0] * 20
right = [0] * 20


def tracking(row, col, cnt, color):
    if col >= N:
        row += 1
        if col % 2 == 0:
            col = 1
        else:
            col = 0

    if row >= N:
        result[color] = max(result[color], cnt)
        return

    if chess[row][col] and not left[col - row + N - 1] and not right[row + col]:
        left[col - row + N - 1] = right[row + col] = 1
        tracking(row, col + 2, cnt + 1, color)
        left[col - row + N - 1] = right[row + col] = 0
    tracking(row, col + 2, cnt, color)


tracking(0, 0, 0, 0)
tracking(0, 1, 0, 1)
print(result[0] + result[1])
