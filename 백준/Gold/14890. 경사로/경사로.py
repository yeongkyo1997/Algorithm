def slope(i, c):
    global result
    cnt = 1
    for j in range(0, N-1):
        d = arr[i][j + 1] - arr[i][j] if c else arr[j + 1][i] - arr[j][i]
        if d == 0:
            cnt += 1
        elif d == 1 and cnt >= L:
            cnt = 1
        elif d == -1 and cnt >= 0:
            cnt = -L+1
        else:
            return
    if cnt >= 0:
        ans += 1


def solve():
    for i in range(N):
        slope(i, 1)
        slope(i, 0)
    print(result)


N, L = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
result = 0
solve()
