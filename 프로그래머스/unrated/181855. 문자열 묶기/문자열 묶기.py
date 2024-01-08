from collections import Counter

def solution(strArr):
    return Counter(map(lambda x:len(x), strArr)).most_common(1)[0][1]