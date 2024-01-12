import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())

print(*sorted(int(input()) for _ in range(n)), sep='\n')