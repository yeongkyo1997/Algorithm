import re

def solution(myStr):
    result = [i for i in re.split(r'[abc]+', myStr) if i]
    return result if result else ['EMPTY']