arr = set()

for _ in range(int(input())):
    arr.add(input())

arr = sorted(arr, key=lambda x: (len(x), x))

print(*arr, sep='\n')