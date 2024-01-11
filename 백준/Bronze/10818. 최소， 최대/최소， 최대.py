import sys


def input(): return sys.stdin.readline().strip()


n = int(input())
arr = list(map(int, input().split()))
print(min(arr), max(arr))