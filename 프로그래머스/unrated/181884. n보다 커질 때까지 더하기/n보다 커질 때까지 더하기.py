def solution(numbers, n):
    result = 0
    for i in numbers:
        if result > n:
            return result
        result += i
    return result
        