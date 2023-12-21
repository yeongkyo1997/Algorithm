def solution(price):
    if price >= 500000:
        return discount(price, 20)
    elif price >= 300000:
        return discount(price, 10)
    elif price >= 100000:
        return discount(price, 5)
    else:
        return price
        
def discount(price, sale):
    return int(price * (1 - sale * 0.01))
