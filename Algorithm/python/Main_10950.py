import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    while n:
        n -= 1
        a, b = map(int, input().split())
        print(a + b)


if __name__ == '__main__':
    main()
