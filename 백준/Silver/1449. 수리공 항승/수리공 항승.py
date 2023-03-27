import sys

# path = __file__[0:-2] + 'txt'
# sys.stdin = open(path, 'r')
input = sys.stdin.readline

result = 0
N, l = map(int, input().split())

arr = list(map(int, input().split()))
arr.sort()

result = 0
e = 0
for i in range(N):
    if e < arr[i]:
        result += 1
        e = arr[i] + l - 1
print(result)
