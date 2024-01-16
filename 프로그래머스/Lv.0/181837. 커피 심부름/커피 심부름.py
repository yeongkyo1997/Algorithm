def solution(order):
    result = 0
    for i in order:
        if 'amer' in i:
            result += 4500
        elif 'cafel' in i:
            result += 5000
        else:
            result += 4500
    return result
            