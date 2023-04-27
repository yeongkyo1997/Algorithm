import sys

input = lambda: sys.stdin.readline().rstrip()


def solve(K, N):
    arr = [0] * (N + 1)
    SUM = 0

    if K == 1:
        SUM += sum(range(1, N + 1))
    else:
        for j in range(0, N + 1):
            arr[N - j] = 1 + j

        for j in range(2, K):
            for k in range(1, N):
                arr[N - k] += arr[N - k + 1]

        for j in range(0, N + 1):
            SUM += arr[j] * j

    return SUM


if __name__ == '__main__':
    cnt = int(input())

    for i in range(cnt):
        K = int(input())
        N = int(input())

        print(solve(K, N))