def solution(s):
    result = []          
    is_first = True     
    
    for c in s:
        if c == ' ':    
            result.append(c)  
            is_first = True   
        else:
            if is_first:
                if c.isalpha():  
                    result.append(c.upper())
                else:            
                    result.append(c)
                is_first = False  
            else:
                result.append(c.lower())  
    
    return ''.join(result)  