import sys


def input(): return sys.stdin.readline().rstrip()


x, y = [int(input()) for _ in range(2)]

if x > 0:
    if y > 0:
        print(1)
    else:
        print(4)
else:
    if y > 0:
        print(2)
    else:
        print(3)