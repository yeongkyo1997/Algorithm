import re


def solution(babbling):
    result = 0
    p1 = re.compile(r'(aya|ye|woo|ma)+')
    p2 = re.compile(r'(aya|ye|woo|ma)\1+')

    for i in babbling:
        if not re.search(p2, i) and re.fullmatch(p1, i):
            result += 1

    return result