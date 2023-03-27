N, M = map(int, input().split())
arr = [i + 1 for i in range(N)]
for _ in range(M):
    a, b, c = map(int, input().split())
    arr = arr[:a - 1] + arr[c - 1:b] + arr[a - 1:c - 1] + arr[b:]
for i in arr:
    print(i, end=' ')