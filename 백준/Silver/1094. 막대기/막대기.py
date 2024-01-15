import sys


def input(): return sys.stdin.readline().rstrip()


x = int(input())

result = 0
for i in range(7):
    if x & (1 << i):
        result += 1

print(result)