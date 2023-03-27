import sys

input = sys.stdin.readline

binary = input().strip()
N = int(binary, 2) * 17

print(format(N, 'b'))
