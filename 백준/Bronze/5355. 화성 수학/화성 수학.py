import sys


def input(): return sys.stdin.readline().rstrip()


T = int(input())

for _ in range(T):
    num, *arr = map(str, input().split())
    num = float(num)

    for i in arr:
        if i == '@':
            num *= 3
        elif i == '%':
            num += 5
        elif i == '#':
            num -= 7
    print(f'{num:.2f}')