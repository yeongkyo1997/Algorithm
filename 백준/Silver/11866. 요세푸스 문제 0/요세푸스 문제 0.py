import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N, K = map(int, input().split())
    arr = [i for i in range(1, N + 1)]
    idx = 0
    print('<', end='')
    while arr:
        idx = (idx + K - 1) % len(arr)
        print(arr.pop(idx), end='')
        if arr:
            print(', ', end='')
    print('>')


if __name__ == '__main__':
    main()