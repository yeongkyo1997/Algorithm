arr = []
N = 9
for _ in range(N):
    arr.append(int(input()))

max_val = max(arr)
print(max_val)
print(arr.index(max_val) + 1)