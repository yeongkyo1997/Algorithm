import copy

def solution(emergency):
    cp = copy.deepcopy(emergency)
    cp.sort(reverse=True)
    result = []
    
    for i in emergency:
        result.append(cp.index(i) + 1)
    
    return result
        
        
    