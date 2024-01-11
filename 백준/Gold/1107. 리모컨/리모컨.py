import sys


def input(): return sys.stdin.readline().strip()


N = int(input())
M = int(input())

if M:
    broken = list(map(int, input().split()))
else:
    broken = []
result = abs(100 - N)

for i in range(1000001):
    num = str(i)
    for j in num:
        if int(j) in broken:
            break
    else:
        result = min(result, len(num) + abs(i - N))
print(result)