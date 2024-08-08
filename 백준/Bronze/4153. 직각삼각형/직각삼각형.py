while True:
    arr = list(map(int, input().split()))
    arr.sort()

    a, b, c = arr
    if a == b == c:
        break
    if a ** 2 + b ** 2 == c ** 2:
        print('right')
    else:
        print('wrong')