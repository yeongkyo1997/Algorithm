import sys

input = lambda: sys.stdin.readline().rstrip()


def solve(N, M, k):
    ret = []
    for i in range(N):
        if k == 0:
            ret.append('0')
            continue
        if N - 1 >= k:
            cnt = comb[N - 1][k]
        else:
            cnt = 0
        if M <= cnt:
            ret.append('0')
            N -= 1
        else:
            ret.append('1')
            M -= cnt
            k -= 1
            N -= 1
    return ''.join(ret)


if __name__ == "__main__":
    MAX_N = 60
    comb = [[0] * (MAX_N + 1) for _ in range(MAX_N + 1)]
    for n in range(MAX_N + 1):
        comb[n][0] = 1
        for k in range(1, n + 1):
            comb[n][k] = comb[n - 1][k - 1] + comb[n - 1][k]
    while True:
        N, M = map(int, input().split())
        if N == 0 and M == 0:
            break
        k = 0
        while k <= N:
            if comb[N][k] >= M:
                break
            M -= comb[N][k]
            k += 1
        result = solve(N, M, k)
        print(result)