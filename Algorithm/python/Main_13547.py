import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 13547 수열과 쿼리 5
def main():
    n = int(input())
    arr = list(map(int, input().split()))
    m = int(input())
    query = [list(map(int, input().split())) for _ in range(m)]

    sqrt = int(n ** 0.5)
    query.sort(key=lambda x: (x[0] // sqrt, x[1]))

    cnt = [0] * (n + 1)
    ans = [0] * m
    l, r = 0, 0
    for i in range(m):
        while l > query[i][0]:
            l -= 1
            cnt[arr[l]] += 1
        while r < query[i][1]:
            r += 1
            cnt[arr[r]] += 1
        while l < query[i][0]:
            cnt[arr[l]] -= 1
            l += 1
        while r > query[i][1]:
            cnt[arr[r]] -= 1
            r -= 1
        ans[query[i][2]] = sum(map(lambda x: x * (x - 1) // 2, cnt))

    print(' '.join(map(str, ans)))


if __name__ == '__main__':
    main()
