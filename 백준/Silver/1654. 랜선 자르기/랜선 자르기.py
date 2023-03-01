import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    K, N = map(int, input().split())

    arr = []
    for i in range(K):
        arr.append(int(input()))

    left = 1
    right = 2 ** 32

    while left <= right:
        mid = (left + right) // 2
        total = 0

        for i in arr:
            total += i // mid

        if N <= total:
            left = mid + 1
        else:
            right = mid - 1

    print(left - 1)


if __name__ == '__main__':
    main()