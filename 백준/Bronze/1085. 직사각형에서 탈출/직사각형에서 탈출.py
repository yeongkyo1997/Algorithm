import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    x, y, w, h = map(int, input().split())

    print(min(x, abs(x - w), y, abs(y - h)))


if __name__ == '__main__':
    main()