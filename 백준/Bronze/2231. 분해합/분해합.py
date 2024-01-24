N = int(input())

result = 0
for i in range(N):
    if sum(map(int, str(i))) + int(i) == N:
        result = i
        break

print(result)