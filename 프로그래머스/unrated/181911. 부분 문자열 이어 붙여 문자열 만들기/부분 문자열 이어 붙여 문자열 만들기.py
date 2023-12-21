def solution(my_strings, parts):
    result = ""
    for i, (s, e) in enumerate(parts):
        result += my_strings[i][s:e+1]
    return result

