import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())

arr = []
for i in range(N):
    start, end = map(int, input().split())
    arr.append((end, start))

arr.sort()

time = arr[0][0]

result = 1

for i in range(1, N):
    if time <= arr[i][1]:
        result += 1
        time = arr[i][0]

print(result)
