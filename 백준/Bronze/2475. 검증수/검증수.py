arr=list(map(int, input().split()))
result = 0
for N in arr:
    result += N ** 2
print(result % 10)