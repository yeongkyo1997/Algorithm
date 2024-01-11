import sys


def input(): return sys.stdin.readline().strip()


print(sum(map(lambda x: int(x) ** 2, input().split())) % 10)