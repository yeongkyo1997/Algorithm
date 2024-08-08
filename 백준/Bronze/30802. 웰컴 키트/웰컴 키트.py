N = int(input())
arr = list(map(int, input().split()))
T, P = map(int, input().split())

result = 0
for a in arr:
    result += (a - 1) // T + 1

print(result)
print(N // P, N % P)