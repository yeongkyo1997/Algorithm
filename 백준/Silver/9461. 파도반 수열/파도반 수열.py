import sys
from functools import cache
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


@cache
def solution(N):
    if N <= 3:
        return 1
    return solution(N - 2) + solution(N - 3)


T = int(input())
for _ in range(T):
    N = int(input())
    print(solution(N))