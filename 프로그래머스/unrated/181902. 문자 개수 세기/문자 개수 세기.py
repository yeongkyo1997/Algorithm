def solution(my_string):
    result = []
    for i in range(ord('A'), ord('Z') + 1):
        result.append(my_string.count(chr(i)))
    for i in range(ord('a'), ord('z') + 1):
        result.append(my_string.count(chr(i)))
        
    return result
         