import sys


def input(): return sys.stdin.readline().strip()


a, b = map(int, input().split())
if a < b:
    print('<')
elif a > b:
    print('>')
else:
    print('==')