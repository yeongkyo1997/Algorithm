import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    print(sum(map(int, list(input()))))


if __name__ == '__main__':
    main()