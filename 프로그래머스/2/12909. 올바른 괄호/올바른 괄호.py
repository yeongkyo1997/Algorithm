def solution(s):
    stack = []
    for i in s:
        if i == '(':
            stack.append('(')
        else:
            if not stack:
                return False
            if stack[-1] == '(':
                stack.pop()
    return not stack
            
        