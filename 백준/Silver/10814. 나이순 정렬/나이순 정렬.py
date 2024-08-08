N = int(input())

arr = [list(input().split()) for _ in range(N)]

arr.sort(key=lambda x: (int(x[0])))

for a in arr:
    print(*a)