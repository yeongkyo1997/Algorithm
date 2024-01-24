arr = [int(input()) for _ in range(5)]
arr.sort()

print(sum(arr) // len(arr))
print(arr[2])