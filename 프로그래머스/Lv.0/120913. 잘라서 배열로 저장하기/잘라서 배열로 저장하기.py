def solution(my_str, n):
    result = []
    for i in range(0, len(my_str), n):
        result.append(my_str[i:min(len(my_str), i+n)])
    
    return result
        