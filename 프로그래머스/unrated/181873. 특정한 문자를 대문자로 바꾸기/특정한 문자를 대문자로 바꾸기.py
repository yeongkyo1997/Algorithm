def solution(my_string, alp):
    result = ''
    for i in list(my_string):
        if i == alp:
            i = i.upper()
        result += i
    return result