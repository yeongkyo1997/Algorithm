import sys


def input(): return sys.stdin.readline().rstrip()


print(''.join(sorted(input(), reverse=True)))