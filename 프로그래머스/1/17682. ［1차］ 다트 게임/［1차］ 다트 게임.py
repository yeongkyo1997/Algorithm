import re
def solution(dartResult):
    arr = list(map(int, re.findall(r'[0-9]+', dartResult)))

    result = [0] * 3
    
    cmd = list(i for i in re.split(r'[0-9]', dartResult) if i != '')
    
    for i, ele in enumerate(cmd):
        tmp = 0
        for j in ele:
            if j == 'S':
                tmp += arr[i]
            elif j == 'D':
                tmp += arr[i] ** 2
            elif j == 'T':
                tmp += arr[i] ** 3
            elif j == '*':
                tmp *= 2
                if i == 0:
                    continue
                result[i - 1] *= 2
            elif j == '#':
                tmp *= -1
        result[i] += tmp
        
    return sum(result)