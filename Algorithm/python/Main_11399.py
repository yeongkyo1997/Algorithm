import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    p = list(map(int, input().split()))
    p.sort()
    result = 0
    for i in range(n):
        result += p[i] * (n - i)
    print(result)


if __name__ == '__main__':
    main()
