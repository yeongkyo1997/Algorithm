N = int(input())

if N % 10 != 0:
    print(-1)
    exit()
arr = N // 300
N %= 300
b = N // 60
N %= 60
c = N // 10
N %= 10

print(arr, b, c)
