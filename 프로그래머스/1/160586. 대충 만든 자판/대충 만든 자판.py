from collections import defaultdict
def solution(keymap, targets):
    lib = defaultdict(lambda: float('inf'))
    for key in keymap:
        for k in key:
            lib[k] = min(lib[k], key.index(k) + 1)
            
    result = []
    for target in targets:
        tmp = 0
        for ch in target:
            if lib[ch] == float('inf'):
                result.append(-1)
                break
            tmp += lib[ch]
        else:
            result.append(tmp)
            
    return result
            
            
