def EPF(n):
    euler = n
    p = 2
    while p * p <= n:
        if n % p == 0:
            euler = euler // p * (p - 1)
        while n % p == 0:
            n //= p
        p += 1
    return euler if n == 1 else euler // n * (n - 1)


def NM(n, m):
    if n == 1 or m == 1:
        return 1
    A = n
    B = NM(n, EPF(m)) + EPF(m)
    result = 1
    while B:
        if B & 1:
            result = result * A % m
        B >>= 1
        A = A * A % m
    return result


def main():
    T = int(input())
    for _ in range(T):
        N, M = map(int, input().split())
        print(NM(N, M) % M)


if __name__ == '__main__':
    main()