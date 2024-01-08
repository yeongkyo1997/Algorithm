def solution(array):
    return sum(cnt_7(i) for i in array)
    
def cnt_7(n):
    if n == 0:
        return 0
    
    if n % 10 == 7:
        return cnt_7(n // 10) + 1
    else:
        return cnt_7(n // 10)
    
