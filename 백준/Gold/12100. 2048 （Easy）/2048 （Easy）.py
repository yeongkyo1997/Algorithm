from collections import deque

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
result, q = 0, deque()


def get(i, j):
    if arr[i][j]:
        q.append(arr[i][j])
        arr[i][j] = 0


def merge(i, j, di, dj):
    while q:
        x = q.popleft()
        if not arr[i][j]:
            arr[i][j] = x
        elif arr[i][j] == x:
            arr[i][j] = x * 2
            i, j = i + di, j + dj
        else:
            i, j = i + di, j + dj
            arr[i][j] = x

def move(k):
    if k == 0:
        for j in range(N):
            for i in range(N):
                get(i, j)
            merge(0, j, 1, 0)
    elif k == 1:
        for j in range(N):
            for i in range(N - 1, -1, -1):
                get(i, j)
            merge(N - 1, j, -1, 0)
    elif k == 2:
        for i in range(N):
            for j in range(N):
                get(i, j)
            merge(i, 0, 0, 1)
    else:
        for i in range(N):
            for j in range(N - 1, -1, -1):
                get(i, j)
            merge(i, N - 1, 0, -1)

def solve(cnt):
    global arr, result
    if cnt == 5:
        for i in range(N):
            ans = max(ans, max(a[i]))
        return
    b = [x[:] for x in a]
    for k in range(4):
        move(k)
        solve(cnt+1)
        a = [x[:] for x in b]


solve(0)
print(result)
