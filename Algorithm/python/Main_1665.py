import sys

input = lambda: sys.stdin.readline().rstrip()

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
m = int(input())
b = [list(map(int, input().split())) for _ in range(m)]

arr = []
for i in range(n):
    for j in range(m):
        arr.append([a[i][0] + b[j][0] - 1, 1])
        arr.append([a[i][0] + b[j][1], -1])
        arr.append([a[i][1] + b[j][0], -1])
        arr.append([a[i][1] + b[j][1] + 1, 1])

arr.sort()
la = -1e9
g = 0
value = 0
answer = 0
result = 0

for i in arr:
    if la != -1e9:
        value += g * (i[0] - la)
    g += i[1]
    la = i[0]
    if answer < value:
        result = i[0] - 1
        answer = value

print(result)
