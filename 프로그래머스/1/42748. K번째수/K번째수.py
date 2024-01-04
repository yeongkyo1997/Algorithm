def solution(array, commands):
    result = []
    
    
    for a, b, c in commands:
        result.append(sorted(array[a - 1 : b])[c - 1])
    return result
        