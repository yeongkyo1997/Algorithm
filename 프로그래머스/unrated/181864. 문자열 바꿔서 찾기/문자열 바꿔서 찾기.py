def solution(myString, pat):
    myString = restr(myString)
    if pat in myString:
        return 1
    else:
        return 0

def restr(string):
    result = ''
    for i in list(string):
        if i == 'A':
            result += 'B'
        else:
            result += 'A'
    return result