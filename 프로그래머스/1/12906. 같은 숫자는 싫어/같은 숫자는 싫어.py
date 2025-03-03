def solution(arr):
    stack = []
    
    for a in arr:
        if not stack:
            stack.append(a)
        elif stack and stack[-1] != a:
            stack.append(a)
    return stack