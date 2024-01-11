import sys


def input(): return sys.stdin.readline().strip()


N, X = map(int, input().split())

print(*filter(lambda x: x < X, map(int, input().split())))