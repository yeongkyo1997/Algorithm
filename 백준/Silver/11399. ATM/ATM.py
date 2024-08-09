N = int(input())
arr = list(map(int, input().split()))
arr.sort()
acc = [0]

for i in range(N):
    acc.append(acc[i] + arr[i])

print(sum(acc))