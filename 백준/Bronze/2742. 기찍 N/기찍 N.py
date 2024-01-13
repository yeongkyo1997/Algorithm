import sys
sys.setrecursionlimit(10 ** 5)


def input(): return sys.stdin.readline().rstrip()


n = int(input())


def solution(n):
    if n == 1:
        print(n)
        return 1

    print(n)
    solution(n - 1)


solution(n)