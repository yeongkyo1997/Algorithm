import math
import sys


def input(): return sys.stdin.readline().rstrip()


n, m = map(int, input().split())

print(math.comb(n, m))