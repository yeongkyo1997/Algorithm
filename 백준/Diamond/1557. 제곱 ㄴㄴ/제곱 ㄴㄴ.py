import sys
import math

input = lambda: sys.stdin.readline().rstrip()


def calc_mobius(n):
    mobius = [1] * (n + 1)
    is_prime = [True] * (n + 1)
    for p in range(2, n + 1):
        if is_prime[p]:
            for multiple in range(p, n + 1, p):
                is_prime[multiple] = False
                mobius[multiple] *= -1
            p_sq = p * p
            for multiple in range(p_sq, n + 1, p_sq):
                mobius[multiple] = 0
    return mobius


def cnt_no_square(n, mobius):
    limit = int(math.isqrt(n))
    ret = 0
    for d in range(1, limit + 1):
        ret += mobius[d] * (n // (d * d))
    return ret


def find(k):
    low = 1
    high = 2 * k

    while low < high:
        mid = (low + high) // 2
        mobius = calc_mobius(int(math.isqrt(mid)) + 1)
        cnt = cnt_no_square(mid, mobius)
        if cnt < k:
            low = mid + 1
        else:
            high = mid
    return low


def main():
    K = int(input())
    result = find(K)
    print(result)


if __name__ == "__main__":
    main()