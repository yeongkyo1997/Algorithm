import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    A, B, V = map(int, input().split())
    print((V - B - 1) // (A - B) + 1)


if __name__ == '__main__':
    main()