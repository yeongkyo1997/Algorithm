import sys
from collections import deque


def input(): return sys.stdin.readline().rstrip()


T = int(input())

for _ in range(T):
    p = input()
    n = int(input())
    x_input = input()[1:-1]
    x = deque(list(map(int, x_input.split(','))) if x_input else [])

    reversed = False
    for i in p:
        if i == 'R':
            reversed = not reversed
        elif i == 'D':
            if x:
                if reversed:
                    x.pop()
                else:
                    x.popleft()
            else:
                print('error')
                break
    else:
        if reversed:
            x.reverse()
        print('[' + ','.join(map(str, x)) + ']')