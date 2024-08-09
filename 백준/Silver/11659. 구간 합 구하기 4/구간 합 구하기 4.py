N, M = map(int, input().split())

arr = list(map(int, input().split()))
acc = [0]

for i in range(1, N + 1):
    acc.append(acc[i - 1] + arr[i - 1])

for _ in range(M):
    a, b = map(int, input().split())
    print(acc[b] - acc[a - 1])