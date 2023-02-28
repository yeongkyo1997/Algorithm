import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(int(input()))
    arr.sort()
    for i in arr:
        print(i)


if __name__ == '__main__':
    main()
