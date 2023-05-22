from functools import lru_cache

MAX = 14
MOD = 9901

N, M = 0, 0
cache = [[-1 for _ in range(1 << MAX)] for _ in range(MAX * MAX)]


@lru_cache(maxsize=None)
def tiling(board, bit):
    global N, M

    if board == N * M and bit == 0:
        return 1

    if board >= N * M:
        return 0

    result = cache[board][bit]
    if result != -1:
        return result

    result = 0

    if bit & 1:
        result = tiling(board + 1, bit >> 1)
    else:
        result = tiling(board + 1, (bit >> 1) | (1 << (M - 1)))

        if board % M != M - 1 and (bit & 2) == 0:
            result += tiling(board + 2, bit >> 2)

    return result % MOD


def main():
    global N, M

    N, M = map(int, input().split())

    result = tiling(0, 0)
    print(result)


if __name__ == "__main__":
    main()