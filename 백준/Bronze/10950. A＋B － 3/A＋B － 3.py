import sys


def input(): return sys.stdin.readline().rstrip()


for _ in range(int(input())):
    print(sum(map(int, input().split())))