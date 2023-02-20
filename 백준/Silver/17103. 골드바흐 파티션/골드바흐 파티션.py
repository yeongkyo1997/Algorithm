import sys
import time

input = sys.stdin.readline


def makePrime(n):
    p = [False] * 2 + [True] * (n + 1)
    for i in range(2, int(n ** 0.5) + 1):
        if p[i]:
            for j in range(i + i, n + 1, i):
                p[j] = False
    return p


prime = makePrime(1000000)
for t in range(int(input())):
    n = int(input())

    result = 0
    for i in range(n // 2 + 1):

        if prime[i] and prime[n - i]:
            result += 1
    print(result)
