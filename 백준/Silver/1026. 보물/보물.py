n = int(input())

a = sorted(map(int, input().split()))
b = sorted(map(int, input().split()), reverse=True)
result = 0

for i, j in zip(a, b):
    result += i * j

print(result)