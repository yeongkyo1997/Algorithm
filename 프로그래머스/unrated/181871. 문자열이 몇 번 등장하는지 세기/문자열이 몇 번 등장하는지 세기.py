def solution(myString, pat):
    return sum(myString[i:].count(pat, 0, len(pat)) for i in range(len(myString)))
