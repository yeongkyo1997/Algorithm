import sys

input = sys.stdin.readline

n, m = map(int, input().split())
div, mod = divmod(n, m)
print(div)
print(mod)
