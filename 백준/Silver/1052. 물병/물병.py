import sys


def input(): return sys.stdin.readline().rstrip()


N, K = map(int, input().split())


result = 0


while bin(N).count('1') > K:
    result += N & -N
    N += N & -N

print(result)