import sys
import math


def input(): return sys.stdin.readline().rstrip()


A, B, V = map(int, input().split())
print(math.ceil((V - B) / (A - B)))