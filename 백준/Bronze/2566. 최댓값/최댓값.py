import sys


def input(): return sys.stdin.readline().rstrip()


arr = [list(map(int, input().split())) for _ in range(9)]

x, y = 0, 0
max_val = 0

for i in range(9):
    for j in range(9):
        if max_val < arr[i][j]:
            x, y = i, j
            max_val = arr[i][j]

print(max_val)
print(x + 1, y + 1)