import re

def solution(my_string):
    my_string = my_string.strip()
    re.sub(r'\s+', ' ', my_string)
    return my_string.split()
    
    