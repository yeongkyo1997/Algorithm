import sys


def input(): return sys.stdin.readline().strip()


n = int(input())

for i in range(n - 1, -1, -1):
    print(f'{" " * i}{"*" * (n - i)}')