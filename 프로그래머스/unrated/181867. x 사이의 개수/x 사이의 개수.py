import re

def solution(myString):
    return [len(s) for s in re.split('x', myString)]

