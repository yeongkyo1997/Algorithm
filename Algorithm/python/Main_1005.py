import sys

input = lambda: sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
    N, K = map(int, input().split())
    time = list(map(int, input().split()))
    suc = [[0] * N for _ in range(N)]
    pre = [0] * N
    for _ in range(K):
        X, Y = map(int, input().split())
        suc[X - 1][Y - 1] = 1
        pre[Y - 1] += 1
    W = int(input()) - 1

    result = [0] * N
    queue = [0] * N
    front = 0
    rear = 0

    for i in range(N):
        if pre[i] == 0:
            queue[rear] = i
            rear += 1

    while pre[W] > 0:
        u = queue[front]
        front += 1
        for next in range(N):
            if suc[u][next] == 1:
                result[next] = max(result[next], result[u] + time[u])
                pre[next] -= 1
                if pre[next] == 0:
                    queue[rear] = next
                    rear += 1

    print(result[W] + time[W])
