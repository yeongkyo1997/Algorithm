import sys

input = sys.stdin.readline

N, M = map(int, input().split())
div, mod = divmod(N, M)
print(div)
print(mod)
