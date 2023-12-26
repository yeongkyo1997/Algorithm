def solution(s):
    result = []
    
    for i in s.split(' '):
        tmp = ''
        for j, ele in enumerate(i):
            if j % 2 == 0:
                tmp += ele.upper()
            else:
                tmp += ele.lower()
        result.append(tmp)
    
    return ' '.join(result)