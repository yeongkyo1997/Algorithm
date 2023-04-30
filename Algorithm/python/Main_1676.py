import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

print(N // 5 + N // 25 + N // 125)
