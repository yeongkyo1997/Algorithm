def solution(s):
    result = []
    lib = {}
    
    for i, ele in enumerate(s):
        if ele in lib:
            result.append(i - lib[ele])
        else:
            result.append(-1)
        lib[ele] = i
    return result