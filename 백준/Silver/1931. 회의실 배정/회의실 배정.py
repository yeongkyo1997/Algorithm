import sys


def input(): return sys.stdin.readline().strip()


n = int(input())

arr = []

for _ in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))

arr.sort(key=lambda x: (x[1], x[0]))


end = arr[0][1]

result = 1
for a, b in arr[1:]:
    if end <= a:
        result += 1
        end = b

print(result)