import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, m = map(int, input().split())
    arr = [0] + list(map(int, input().split()))
    for i in range(1, n + 1):
        arr[i] += arr[i - 1]
    for _ in range(m):
        a, b = map(int, input().split())
        print(arr[b] - arr[a - 1])


if __name__ == '__main__':
    main()
