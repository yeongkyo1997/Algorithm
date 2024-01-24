while True:
    a, b, c = map(int, input().split())
    arr = sorted([a, b, c])
    if a == b == c == 0:
        break
    elif arr[0] + arr[1] <= arr[2]:
        print('Invalid')
    elif len(set([a, b, c])) == 1:
        print('Equilateral')
    elif len(set([a, b, c])) == 2:
        print('Isosceles')
    elif len(set([a, b, c])) == 3:
        print('Scalene')