from collections import defaultdict
def solution(name, yearning, photo):
    lib = defaultdict(int)
    
    for key, value in zip(name, yearning):
        lib[key] = value
    
    result = []
    
    for i in photo:
        result.append(sum(lib[j] for j in i ))
        
    return result
