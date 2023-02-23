import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = list(map(int, input().split()))

    print(min(arr))
    print(max(arr))


if __name__ == '__main__':
    main()