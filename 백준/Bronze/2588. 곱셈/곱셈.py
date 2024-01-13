import sys


def input(): return sys.stdin.readline().rstrip()


a = int(input())
b = int(input())
tmp = b

while tmp:
    print(a * (tmp % 10))
    tmp //= 10

print(a * b)