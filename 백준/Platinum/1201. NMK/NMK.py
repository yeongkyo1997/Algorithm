import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, M, K = map(int, input().split())

    if M + K - 1 <= N <= M * K:

        arr = [i for i in range(1, N + 1)]

        idx = 0

        for i in range(1, M + 1):
            temp = min(idx + K, N - M + i)

            arr[idx:temp] = reversed(arr[idx:temp])

            idx = temp

        print(*arr)

    else:

        print(-1)


if __name__ == '__main__':
    main()