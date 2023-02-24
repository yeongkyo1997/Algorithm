import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    T = int(input())

    while T:
        T -= 1
        arr = map(int, input().split())
        arr = list(arr)
        arr.sort(reverse=True)
        print(arr[2])


if __name__ == '__main__':
    main()
