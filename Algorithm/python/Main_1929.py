import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def isPrime(x):
    if x < 2:
        return False

    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True


def main():
    M, N = map(int, input().split())

    for i in range(M, N + 1):
        if isPrime(i):
            print(i)


if __name__ == '__main__':
    main()
