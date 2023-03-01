import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    arr = map(int, input().split())
    cnt = 0
    for i in arr:
        if isPrime(i):
            cnt += 1
    print(cnt)


def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


if __name__ == '__main__':
    main()