import sys


def input(): return sys.stdin.readline().rstrip()


def is_right(arr):
    a, b, c = sorted(arr)
    if a ** 2 + b ** 2 == c ** 2:
        return 'right'
    else:
        return 'wrong'


while True:
    a, b, c = map(int, input().split())

    if a == b == c == 0:
        break
    print(is_right([a, b, c]))