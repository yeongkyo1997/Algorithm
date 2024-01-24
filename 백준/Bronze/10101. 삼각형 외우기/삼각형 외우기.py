a = int(input())
b = int(input())
c = int(input())

if a == b == c:
    print('Equilateral')
elif a + b + c == 180:
    if len(set([a, b, c])) == 2:
        print('Isosceles')
    else:
        print('Scalene')
else:
    print('Error')