import re

def solution(s):
    stack = []
    
    for i in s:
        if stack:
            if stack[-1] == i:
                stack.pop()
            else:
                stack.append(i)
        else:
            stack.append(i)
    
    return int(not stack)