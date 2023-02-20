import sys

input = sys.stdin.readline

binary = input().strip()
n = int(binary, 2) * 17

print(format(n, 'b'))
