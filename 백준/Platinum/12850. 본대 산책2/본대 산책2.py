import sys

input = lambda: sys.stdin.readline().rstrip()

MOD = 1000000007


def multiply(M1, M2):
    ret = [[0] * 8 for _ in range(8)]
    for i in range(8):
        for j in range(8):
            ele = 0
            for k in range(8):
                ele += (M1[i][k] * M2[k][j])
                ele %= MOD
            ret[i][j] = ele % MOD
    return ret


def main():
    D = int(input().strip())

    v = [
        [0, 1, 1, 0, 0, 0, 0, 0],
        [1, 0, 1, 1, 0, 0, 0, 0],
        [1, 1, 0, 1, 1, 0, 0, 0],
        [0, 1, 1, 0, 1, 1, 0, 0],
        [0, 0, 1, 1, 0, 1, 0, 1],
        [0, 0, 0, 1, 1, 0, 1, 0],
        [0, 0, 0, 0, 0, 1, 0, 1],
        [0, 0, 0, 0, 1, 0, 1, 0]
    ]

    ret = [[1 if i == j else 0 for j in range(8)] for i in range(8)]
    factor = v

    while D:
        if D & 1:
            ret = multiply(ret, factor)
            D -= 1
        factor = multiply(factor, factor)
        D //= 2

    print(ret[0][0])


if __name__ == "__main__":
    main()