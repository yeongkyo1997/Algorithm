MAX = 10001
arr = [True] * MAX
arr[0] = arr[1] = False

for i in range(2, MAX):
    if arr[i]:
        for j in range(i * i, MAX, i):
            arr[j] = False

for _ in range(int(input())):
    n = int(input())
    result = [0, float('inf')]
    for i in range(2, n // 2 + 1):
        if arr[i] and arr[n - i] and n - i - i < result[1] - result[0]:
            result = [i, n - i]
    print(*result)