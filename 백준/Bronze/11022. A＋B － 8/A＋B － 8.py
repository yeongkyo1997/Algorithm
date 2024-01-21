import sys


def input(): return sys.stdin.readline().rstrip()


for i in range(int(input())):
    a, b = map(int, input().split())
    print(f'Case #{i + 1}: {a} + {b} = {a + b}')