import sys
import math


def input(): return sys.stdin.readline().rstrip()


print(math.comb(*map(int, input().split())) % 10007)