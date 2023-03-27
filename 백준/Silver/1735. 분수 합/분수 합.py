import math
import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

a1, b1 = map(int, input().split())
a2, b2 = map(int, input().split())

up = a1 * b2 + a2 * b1
down = b1 * b2
gcd = math.gcd(up, down)
print(up // gcd, down // gcd)