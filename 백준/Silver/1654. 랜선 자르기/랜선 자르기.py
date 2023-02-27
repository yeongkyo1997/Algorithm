n, k = map(int, input().split())

arr = []

for _ in range(n):
    arr.append(int(input()))

left = 1
right = max(arr)

while left <= right:
    mid = (left + right) // 2
    cnt = 0
    for i in arr:
        cnt += i // mid

    if cnt >= k:
        left = mid + 1
    else:
        right = mid - 1

print(right)