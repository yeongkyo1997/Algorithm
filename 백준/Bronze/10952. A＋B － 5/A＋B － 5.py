import sys


def input(): return sys.stdin.readline().strip()


while True:
    a, b = map(int, input().split())
    if a == b == 0:
        break
    print(a + b)