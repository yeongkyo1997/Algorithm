import re

def solution(myString, pat):
    st = f'(\w*{pat})'
    sub = re.findall(st, myString)
    
    return sorted(sub, key=lambda x: len(x))[-1]
