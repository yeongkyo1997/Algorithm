import sys


def input(): return sys.stdin.readline().strip()


print(len(set(int(input()) % 42 for _ in range(10))))