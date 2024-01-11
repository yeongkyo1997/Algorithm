import math
import sys


def input(): return sys.stdin.readline().strip()


n, k = map(int, input().split())

print(math.comb(n, k))