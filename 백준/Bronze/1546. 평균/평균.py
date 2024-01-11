import sys


def input(): return sys.stdin.readline().strip()


n = int(input())
arr = list(map(int, input().split()))
arr = list(map(lambda x: x / max(arr) * 100, arr))
print(sum(arr) / len(arr))