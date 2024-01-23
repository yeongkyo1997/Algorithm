import sys


def input(): return sys.stdin.readline().rstrip()


x = int(input())


line = 1


while x > line:
    x -= line
    line += 1


if line % 2 == 0:
    print(fr'{x}/{line - x + 1}')
else:
    print(fr'{line - x + 1}/{x}')