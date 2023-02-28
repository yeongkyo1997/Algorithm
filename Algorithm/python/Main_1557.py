# BOJ 1557. 제곱 ㄴㄴ수

import sys

input = lambda: sys.stdin.readline().rstrip()


def nono_square(n):
    if n < 2:
        return 0
    res = n - 1
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            res -= res // i
            while n % i == 0:
                n //= i
    if n > 1:
        res -= res // n
    return res


def main():
    n = int(input())
    left = 1
    right = 2 * 10 ** 9
    while left < right:
        mid = (left + right) // 2
        if nono_square(mid) < n:
            left = mid + 1
        else:
            right = mid
    print(left)


if __name__ == '__main__':
    main()