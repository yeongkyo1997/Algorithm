def solution(picture, k):
    result = []
    for i in picture:
        for _ in range(k):
            result.append(''.join(map(lambda x: x*k, i)))
    return result