import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    arr = input().strip().split(' ')
    print(len(arr))


if __name__ == '__main__':
    main()
