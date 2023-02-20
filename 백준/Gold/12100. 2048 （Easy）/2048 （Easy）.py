from collections import deque
n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
ans, q = 0, deque()

def get(i, j):
    if a[i][j]:
        q.append(a[i][j])
        a[i][j] = 0

def merge(i, j, di, dj):
    while q:
        x = q.popleft()
        if not a[i][j]:
            a[i][j] = x
        elif a[i][j] == x:
            a[i][j] = x*2
            i, j = i+di, j+dj
        else:
            i, j = i+di, j+dj
            a[i][j] = x

def move(k):
    if k == 0:
        for j in range(n):
            for i in range(n):
                get(i, j)
            merge(0, j, 1, 0)
    elif k == 1:
        for j in range(n):
            for i in range(n-1, -1, -1):
                get(i, j)
            merge(n-1, j, -1, 0)
    elif k == 2:
        for i in range(n):
            for j in range(n):
                get(i, j)
            merge(i, 0, 0, 1)
    else:
        for i in range(n):
            for j in range(n-1, -1, -1):
                get(i, j)
            merge(i, n-1, 0, -1)

def solve(cnt):
    global a, ans
    if cnt == 5:
        for i in range(n):
            ans = max(ans, max(a[i]))
        return
    b = [x[:] for x in a]
    for k in range(4):
        move(k)
        solve(cnt+1)
        a = [x[:] for x in b]

solve(0)
print(ans)