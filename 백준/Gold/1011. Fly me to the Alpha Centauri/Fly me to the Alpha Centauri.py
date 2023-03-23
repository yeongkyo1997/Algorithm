import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for i in range(T):
    x, y = map(int, input().split())
    distance = y - x
    max = int(distance ** 0.5)
    if max == distance ** 0.5:
        print(max * 2 - 1)
    elif distance <= max * max + max:
        print(max * 2)
    else:
        print(max * 2 + 1)
