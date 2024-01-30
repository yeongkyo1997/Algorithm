import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
print(*sorted(list(map(int, input().split())) + list(map(int, input().split()))))