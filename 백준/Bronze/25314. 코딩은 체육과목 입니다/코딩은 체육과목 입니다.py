import sys


def input(): return sys.stdin.readline().rstrip()


N = int(input())


print('long ' * (N // 4) + 'int')