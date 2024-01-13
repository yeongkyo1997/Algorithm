import sys


def input(): return sys.stdin.readline().rstrip()


n = int(input())
print((n * (n + 1)) // 2)