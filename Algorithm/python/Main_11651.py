n = int(input())

arr = []

for i in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))

for a, b in sorted(arr, key=lambda x: (x[1], x[0])):
    print(f'{a} {b}')
