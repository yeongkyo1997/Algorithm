import sys

input = lambda: sys.stdin.readline().rstrip()


def solve(x, y, size):
    global one, m_one, ze
    flag = True

    for i in range(y, y + size):
        for j in range(x, x + size):
            if MAP[i][j] != MAP[y][x]:
                flag = False
                break
        if not flag:
            break
    if not flag:
        solve(x, y, size // 3)
        solve(x + size // 3, y, size // 3)
        solve(x + size // 3 + size // 3, y, size // 3)
        solve(x, y + size // 3, size // 3)
        solve(x, y + size // 3 + size // 3, size // 3)
        solve(x + size // 3, y + size // 3, size // 3)
        solve(x + size // 3 + size // 3, y + size // 3 + size // 3, size // 3)
        solve(x + size // 3, y + size // 3 + size // 3, size // 3)
        solve(x + size // 3 + size // 3, y + size // 3, size // 3)
    else:
        if MAP[y][x] == 1:
            one += 1
        elif MAP[y][x] == -1:
            m_one += 1
        else:
            ze += 1


n = int(input())
MAP = [list(map(int, input().split())) for _ in range(n)]
one = 0
m_one = 0
ze = 0
solve(0, 0, n)
print(m_one)
print(ze)
print(one)
