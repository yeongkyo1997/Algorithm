from bisect import bisect_left

for t in range(1, int(input()) + 1):
    input()
    arr = list(map(int, input().split()))
    dp = []

    for a in arr:
        k = bisect_left(dp, a)
        if len(dp) <= k:
            dp += [a]
        else:
            dp[k] = a

    print(f'#{t} {len(dp)}')
