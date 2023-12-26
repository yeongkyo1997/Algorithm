def solution(s, n):
    result = ''
    
    for i in s:
        if i.isalpha():
            start = ord('A') if i.isupper() else ord('a')
        
            result += chr((ord(i) - start + n) % 26 + start)
        else:
            result += i
        
    return result