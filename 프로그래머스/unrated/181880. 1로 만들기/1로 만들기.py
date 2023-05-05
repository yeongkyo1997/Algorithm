def solution(num_list):
    result = 0
    for i in num_list:
        result += div(i)
    return result

def div(num):
    result = 0
    
    while num != 1:
        if  num % 2 == 0:
            num //= 2
        else:
            num -= 1
            num //= 2
        result += 1
    return result
    