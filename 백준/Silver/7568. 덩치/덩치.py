N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

for cx, cy in arr:
    cnt = 1
    for ax, ay in arr:
        if cx < ax and cy < ay:
            cnt += 1

    print(cnt, end=' ')