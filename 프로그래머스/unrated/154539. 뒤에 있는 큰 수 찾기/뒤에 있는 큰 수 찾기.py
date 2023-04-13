def solution(numbers):
    stack = []
    
    for i in range(len(numbers)):        
        while stack and numbers[i] > numbers[stack[-1]]:
            numbers[stack.pop()] = numbers[i]
            
        stack.append(i)
        
    for i in stack:
        numbers[i] = -1
        
    return numbers
            