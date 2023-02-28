import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())

    for i in range(N):
        if solve(i) == N:
            print(i)
            return
    print(0)


def solve(N):
    result = N

    while N != 0:
        result += N % 10
        N //= 10

    return result


if __name__ == '__main__':
    main()
