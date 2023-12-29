def solution(food):
    half = [i // 2 for i in food]
    
    result = ''.join(str(i) * ele for i, ele in enumerate(half) if ele != 0)
    return result + '0' + result[::-1]