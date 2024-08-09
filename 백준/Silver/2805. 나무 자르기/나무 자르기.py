N, M = map(int, input().split())

arr = list(map(int, input().split()))

start = 1
end = max(arr)

while start <= end:
    mid = (start + end) // 2

    tree = 0
    for a in arr:
        if a > mid:
            tree += a - mid

    if tree >= M:
        start = mid + 1
    else:
        end = mid - 1

print(end)