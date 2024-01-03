def solution(a, d, included):
    return sum(a + d * i for i, ele in enumerate(included, start = 0) if ele)