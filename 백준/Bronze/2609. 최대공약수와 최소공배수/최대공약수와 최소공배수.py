import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

a, b = map(int, input().split())
print(math.gcd(a, b))
print(math.lcm(a, b))
