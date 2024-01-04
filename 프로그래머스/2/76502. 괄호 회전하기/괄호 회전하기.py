from collections import deque

def solution(s):
    q = deque(s) 

    def check(q):
        stack = []
        for i in q:
            if i in '([{':
                stack.append(i)
            elif stack:
                if stack[-1] == '(' and i == ')':
                    stack.pop()
                elif stack[-1] == '[' and i == ']':
                    stack.pop()
                elif stack[-1] == '{' and i == '}':
                    stack.pop()
                else:
                    return False
            else:
                return False  

        return not stack  
    result = 0 
    for i in range(len(q)):
        if check(q):
            result += 1
        q.rotate(-1)
            
    return result
