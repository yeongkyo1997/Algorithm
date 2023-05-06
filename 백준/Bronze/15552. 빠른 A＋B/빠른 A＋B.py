import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    for _ in range(int(input())):
        print(sum(map(int, input().split())))


if __name__ == '__main__':
    main()