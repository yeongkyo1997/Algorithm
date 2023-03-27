def rotate(n, d):
    t = [0]*8
    if d == 1:
        for i in range(8):
            t[(i + 1) % 8] = arr[n][i]
    else:
        for i in range(8):
            t[i] = arr[n][(i + 1) % 8]
    for i in range(8):
        arr[n][i] = t[i]

def solve():
    for _ in range(int(input())):
        n, d = map(int, input().split())
        direct = [0]*4
        direct[n-1] = d
        for i in range(n-1, 3):
            if arr[i][2] != arr[i + 1][6]:
                direct[i + 1] = -direct[i]
        for i in range(n-1, 0, -1):
            if arr[i][6] != arr[i - 1][2]:
                direct[i - 1] = -direct[i]
        for i in range(4):
            if direct[i]:
                rotate(i, direct[i])


arr = [list(input().strip()) for _ in range(4)]
solve()
result = 0
for i in range(4):
    if arr[i][0] == '1':
        result += (1 << i)
print(result)
