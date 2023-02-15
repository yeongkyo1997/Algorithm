import re

def solution(files):
    p = re.compile(r'(\D{1,})(\d{1,})(.*)')
    result = []
    
    for file in files:
        result.extend(re.findall(p, file))
    result = sorted(result, key=lambda x: (x[0].lower(), int(x[1])))
    return list(map(lambda x:''.join(x), result))