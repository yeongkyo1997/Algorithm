def solution(X, Y):
    lib_x = {}
    lib_y = {}
    
    for i in X:
        lib_x[i] = lib_x.get(i, 0) + 1
        
    for i in Y:
        lib_y[i] = lib_y.get(i, 0) + 1
    
    result = ''
    
    for i in map(str, range(9, -1, -1)):
        count = min(lib_x.get(i, 0), lib_y.get(i, 0))
        result += i * count
        
    if result:
        if result[0] == '0':
            return '0'
        else:
            return result
    return '-1'
