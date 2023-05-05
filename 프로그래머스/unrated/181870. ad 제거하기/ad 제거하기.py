def solution(strArr):
    result = []
    for i in strArr:
        if 'ad' in i:
            continue
        result.append(i)
    return result