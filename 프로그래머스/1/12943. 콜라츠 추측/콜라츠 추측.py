def solution(num):
    result = 0
    
    while num != 1:
        if num % 2 == 0:
            num //= 2
        else:
            num *= 3
            num += 1
        result += 1
    return result if result <= 500 else -1