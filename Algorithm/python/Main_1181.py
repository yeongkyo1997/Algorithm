import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = set()

    for _ in range(N):
        arr.add(input())

    arr = sorted(arr, key=lambda x: (len(x), x))

    for i in arr:
        print(i)


if __name__ == '__main__':
    main()
