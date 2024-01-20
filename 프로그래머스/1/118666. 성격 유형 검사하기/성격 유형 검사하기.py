def solution(survey, choices):
    lib = {a : 0 for a in 'RTCFJMAN'}
    
    for s, c in zip(survey, choices):
        a, b = s
        if c < 4:
            lib[a] += abs(c - 4)
        else:
            lib[b] += abs(c - 4)
    
    result = ''
    print(lib)
    
    for a, b in [('R', 'T'), ('C', 'F'), ('J', 'M'), ('A', 'N')]:
        if lib[a] > lib[b]:
            result += a
        elif lib[a] < lib[b]:
            result += b
        else:
            result += min(a, b)
    return result
