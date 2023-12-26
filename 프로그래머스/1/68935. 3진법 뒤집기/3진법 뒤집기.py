def solution(n):
    # return list(enumerate(three_digit(n)))
    return sum(int(ele) * (3 ** i) for i, ele in enumerate(three_digit(n)))
    
def three_digit(n):
    result = ''
    
    while n != 0:
        result += str(n % 3)
        n //= 3
    
    return result[::-1]
    