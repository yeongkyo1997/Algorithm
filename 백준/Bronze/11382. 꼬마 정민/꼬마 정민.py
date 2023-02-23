import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    print(sum(map(int, input().split())))


if __name__ == '__main__':
    main()