import sys

input = sys.stdin.readline

n = int(input())

for i in range(n - 1, -n, -1):
    print(f"{' ' * abs(i)}{'*' * (n - abs(i))}")
