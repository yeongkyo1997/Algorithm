import sys
from functools import cache
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


n = int(input())

arr = [int(input()) for _ in range(n)]


@cache
def solution(n):
    if n == 0:
        return arr[n]
    elif n == 1:
        return arr[0] + arr[1]
    elif n == 2:
        return max(arr[0] + arr[2], arr[1] + arr[2], solution(n - 1))

    return max(solution(n - 1), solution(n - 2) + arr[n], solution(n - 3) + arr[n - 1] + arr[n])


print(solution(n - 1))