import sys


def input(): return sys.stdin.readline().strip()


a, b = map(int, input().split())

print(f'{a + b}\n{a - b}\n{a * b}\n{a // b}\n{a % b}')