import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    for i in (sorted([int(input()) for _ in range(n)])):
        print(i)


if __name__ == '__main__':
    main()