import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n, k = map(int, input().split())
    result = 1
    for i in range(k):
        result *= n - i
        result //= i + 1
    print(result)


if __name__ == '__main__':
    main()
