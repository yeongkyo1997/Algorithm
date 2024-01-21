import sys


def input(): return sys.stdin.readline().rstrip()


arr = [int(input()) for _ in range(28)]
s = set(arr)
print(*sorted(set(range(1, 31)) - s), sep='\n')