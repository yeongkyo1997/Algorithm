from collections import defaultdict

def solution(X, Y):
    lib_x = defaultdict(int)
    lib_y = defaultdict(int)
    
    for i in X:
        lib_x[i] += 1
        
    for i in Y:
        lib_y[i] += 1
    
    result = ''
    
    for i in map(str, range(10, -1, -1)):
        result += i * min((lib_x[i]), lib_y[i])
        
    if result:
        if result[0] == '0':
            return '0'
        else:
            return result
    return '-1'