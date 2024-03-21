import sys


def input(): return sys.stdin.readline().rstrip()


S = input()


print(sum(map(int, S.split(','))))