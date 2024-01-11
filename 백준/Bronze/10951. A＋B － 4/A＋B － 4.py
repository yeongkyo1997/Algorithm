import sys


def input(): return sys.stdin.readline().strip()


while True:
    try:
        a, b = map(int, input().split())
        print(a + b)
    except:
        break