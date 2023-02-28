import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    arr = [int(input()) for i in range(9)]
    print(max(arr))
    print(arr.index(max(arr)) + 1)


if __name__ == '__main__':
    main()
