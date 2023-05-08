import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())

    arr = [int(input()) for _ in range(n)]

    arr.sort(reverse=True)

    for i in arr:
        print(i)


if __name__ == '__main__':
    main()
