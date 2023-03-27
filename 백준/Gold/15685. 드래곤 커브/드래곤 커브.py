v, result = [0], 0
arr = [[0] * 101 for _ in range(101)]
dx, dy = (1, 0, -1, 0), (0, -1, 0, 1)

for i in range(1, 11):
    k = 1 << (i - 1)
    for j in range(k):
        v.append((v[k - j - 1] + 1) % 4)

for _ in range(int(input())):
    x, y, d, g = map(int, input().split())
    arr[x][y] = 1
    for i in range(1 << g):
        x, y = x + dx[(v[i] + d) % 4], y + dy[(v[i] + d) % 4]
        arr[x][y] = 1

for i in range(100):
    for j in range(100):
        if arr[i][j] and arr[i + 1][j] and arr[i][j + 1] and arr[i + 1][j + 1]:
            result += 1
print(result)
