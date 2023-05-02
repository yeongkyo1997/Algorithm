def solution(myString):
    result = ''
    
    for i in list(myString):
        if ord(i) < ord('l'):
            result += 'l'
        else:
            result += i
    return result