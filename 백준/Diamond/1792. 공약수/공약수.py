import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    Mu = [0] * 50001
    Mu[1] = 1

    for i in range(1, 50001):
        for j in range(2 * i, 50001, i):
            Mu[j] -= Mu[i]
        Mu[i] += Mu[i - 1]

    for _ in range(N):
        a, b, d = map(int, input().split())
        if a > b:
            a, b = b, a
        a //= d
        b //= d
        ret = 0

        ia = 1
        while ia <= a:
            ja = min(a // (a // ia), a)
            ib = ia
            while ib <= ja:
                jb = min(b // (b // ib), ja)
                ret += (Mu[jb] - Mu[ib - 1]) * (a // ib) * (b // ib)
                ib = jb + 1
            ia = ja + 1

        print(f"{ret}")


if __name__ == "__main__":
    main()