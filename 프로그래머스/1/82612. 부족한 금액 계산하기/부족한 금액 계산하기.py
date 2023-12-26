def solution(price, money, count):
    result = sum(price * i for i in range(1, count + 1)) - money 
    return result if result > 0 else 0