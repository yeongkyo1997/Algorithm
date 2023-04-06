import sys

input = lambda: sys.stdin.readline().rstrip()

arr = []
for _ in range(int(input())):
    arr.append(int(input()))

arr = list(map(lambda x: x - 1, arr))
result = sum(arr) + 1
print(result)
