import sys
import math


def input(): return sys.stdin.readline().rstrip()


N, game = input().split()
N = int(N)

s = set(input() for _ in range(N))

if game == 'Y':
    print(len(s))
elif game == 'F':
    print(len(s) // 2)
elif game == 'O':
    print(len(s) // 3)