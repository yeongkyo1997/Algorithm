def rotate(n, d):
    t = [0]*8
    if d == 1:
        for i in range(8):
            t[(i+1)%8] = a[n][i]
    else:
        for i in range(8):
            t[i] = a[n][(i+1)%8]
    for i in range(8):
        a[n][i] = t[i]

def solve():
    for _ in range(int(input())):
        n, d = map(int, input().split())
        direct = [0]*4
        direct[n-1] = d
        for i in range(n-1, 3):
            if a[i][2] != a[i+1][6]:
                direct[i+1] = -direct[i]
        for i in range(n-1, 0, -1):
            if a[i][6] != a[i-1][2]:
                direct[i-1] = -direct[i]
        for i in range(4):
            if direct[i]:
                rotate(i, direct[i])

a = [list(input().strip()) for _ in range(4)]
solve()
ans = 0
for i in range(4):
    if a[i][0] == '1':
        ans += (1<<i)
print(ans)


            