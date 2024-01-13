import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())
arr = list(map(int, input().split()))
arr.sort()
print(sum(sum(arr[:i + 1]) for i in range(N)))