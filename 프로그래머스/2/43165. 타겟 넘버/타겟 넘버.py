def solution(numbers, target):
    result = 0
    for i in range((1 << len(numbers)) + 1):
        num = 0
        for j in range(len(numbers)):
            if i & (1 << j):
                num += numbers[j]
            else:
                num -= numbers[j]
        if num == target:
            result += 1
            
    return result
            
        