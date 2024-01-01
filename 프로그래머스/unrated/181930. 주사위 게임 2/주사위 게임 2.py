def solution(a, b, c):
    one = sum([a, b, c])
    two = sum(map(lambda x : x ** 2, [a, b, c]))
    three = sum(map(lambda x : x ** 3, [a, b, c]))
    
    if a == b == c:
        return one * two * three
    elif a == b or b == c or a == c:
        return one * two
    else:
        return one