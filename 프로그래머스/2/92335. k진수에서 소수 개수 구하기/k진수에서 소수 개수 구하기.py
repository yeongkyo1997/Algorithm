def solution(n, k):
    n = change(n, k)
    n_list = [int(i) for i in str(n).split('0') if i]
    return sum(1 for i in n_list if is_prime(i))

def is_prime(x):
    if x == 0 or x == 1:
        return False
    for i in range(2, int(x ** 0.5) + 1):
        if x % i == 0:
            return False 
    return True 

def change(n, k):
    result = ''
    
    while n:
        result += str(n % k)
        n //= k
    
    return result[::-1]

