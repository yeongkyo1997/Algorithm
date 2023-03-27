arr, b, c = map(int, input().split())

if arr == b == c:
    print(10000 + arr * 1000)
elif arr == b or arr == c:
    print(1000 + arr * 100)
elif b == c:
    print(1000 + b * 100)
else:
    print(max(arr, b, c) * 100)
