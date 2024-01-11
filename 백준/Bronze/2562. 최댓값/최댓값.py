import sys


def input(): return sys.stdin.readline().strip()


arr = [int(input()) for _ in range(9)]

max_val = max(arr)
print(max_val)
print(arr.index(max_val) + 1)