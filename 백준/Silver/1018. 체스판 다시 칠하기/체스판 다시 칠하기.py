import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def check(x, y, color):
    cnt = 0
    for i in range(8):
        for j in range(8):
            if board[x + i][y + j] != color[(i + j) % 2]:
                cnt += 1
    return cnt


def sol():
    ans = 64
    for i in range(n - 7):
        for j in range(m - 7):
            ans = min(ans, check(i, j, 'WB'), check(i, j, 'BW'))
    return ans


n, m = map(int, input().split())
board = [input() for _ in range(n)]
print(sol())