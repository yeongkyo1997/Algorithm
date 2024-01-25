import sys

sys.setrecursionlimit(10 ** 5)

N = int(input())


def factorial(N):
    if N == 0:
        return 1

    return factorial(N - 1) * N


print(factorial(N))