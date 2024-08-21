import math
import sys

input = lambda: sys.stdin.readline().rstrip()


def lcm(a, b):
    return a * b // math.gcd(a, b)


def main():
    n, P = map(int, input().split())

    if P == 2:
        if n * P > 10 ** 9:
            print(0)
        else:
            print(n * P)
    elif P < 50:
        Prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
        while Prime[-1] >= P:
            Prime.pop()

        def Check(mid):
            ret = mid
            for i in range(1, 1 << len(Prime)):
                t, cnt = 1, 0
                for j in range(len(Prime)):
                    if not (i & (1 << j)):
                        continue
                    if lcm(t, Prime[j]) > mid:
                        break
                    t = lcm(t, Prime[j])
                    cnt += 1
                else:
                    ret += mid // t * (-1 if cnt & 1 else 1)
            return ret

        lo, hi = 0, 10 ** 9
        while lo + 1 < hi:
            mid = (lo + hi) >> 1
            if Check(mid) < n:
                lo = mid
            else:
                hi = mid

        if hi * P > 10 ** 9:
            print(0)
        else:
            print(hi * P)
    else:
        B = [False] * 20000001
        for i in range(2, min(P, 20000001)):
            if B[i]:
                continue
            for j in range(i, 20000001, i):
                B[j] = True

        cnt, pos = 0, 0
        for i in range(1, 20000001):
            if not B[i]:
                cnt += 1
                pos = i
            if cnt == n:
                break

        if cnt < n or pos * P > 10 ** 9:
            print(0)
        else:
            print(pos * P)


if __name__ == "__main__":
    main()