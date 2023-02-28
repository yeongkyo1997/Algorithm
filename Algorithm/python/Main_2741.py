import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    [print(i) for i in range(1, int(input()) + 1)]


if __name__ == '__main__':
    main()
