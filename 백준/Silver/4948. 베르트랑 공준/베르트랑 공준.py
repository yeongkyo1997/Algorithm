MAX = 1234567
arr = [True] * MAX
arr[0] = arr[1] = False
for i in range(2, MAX):
    if arr[i]:
        for j in range(i ** 2, MAX, i):
            arr[j] = False


while True:
    n = int(input())
    if n == 0:
        break

    print(sum(1 for i in range(n + 1, n * 2 + 1) if arr[i]))