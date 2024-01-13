import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())

print(*sorted([int(input()) for _ in range(N)]), sep='\n')