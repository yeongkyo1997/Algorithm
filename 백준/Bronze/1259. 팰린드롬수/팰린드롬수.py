import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

while True:
    n = input()
    if n == '0':
        break
    print('yes' if n == n[::-1] else 'no')