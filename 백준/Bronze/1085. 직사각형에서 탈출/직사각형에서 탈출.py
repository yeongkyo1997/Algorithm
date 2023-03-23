import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

x, y, w, h = map(int, input().split())
print(min(x, y, w - x, h - y))