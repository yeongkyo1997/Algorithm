def solution(rsp):
    result = ''
    
    for char in rsp:
        if char == '2':
            result += '0'
        elif char == '0':
            result += '5'
        else:
            result += '2'
        
    return result