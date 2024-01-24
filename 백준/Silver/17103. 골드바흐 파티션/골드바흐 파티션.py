MAX = 1000001
arr = [True] * MAX
arr[1] = False

for i in range(2, MAX):
    if arr[i]:
        for j in range(i * i, MAX, i):
            arr[j] = False

for _ in range(int(input())):
    n = int(input())
    result = 0
    for i in range(2, n // 2 + 1):
        if arr[i] and arr[n - i]:
            result += 1
    print(result)