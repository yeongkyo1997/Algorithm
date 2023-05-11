def solution(intStrs, k, s, l):
    result = []
    for string in intStrs:
        sub_str = string[s:s+l]
        num = int(sub_str)
        if num > k:
            result.append(num)
    return result