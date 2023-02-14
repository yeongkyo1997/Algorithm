import re
import math


def solution(str1, str2):
    set1 = [str1[i:i + 2].lower() for i in range(0, len(str1) - 1) if not re.findall('[^a-zA-Z]+', str1[i:i + 2])]
    set2 = [str2[i:i + 2].lower() for i in range(0, len(str2) - 1) if not re.findall('[^a-zA-Z]+', str2[i:i + 2])]

    cap = set(set1) & set(set2)
    cup = set(set1) | set(set2)

    sum1 = sum(min(set1.count(i), set2.count(i)) for i in cap)
    sum2 = sum(max(set1.count(i), set2.count(i)) for i in cup)
    try:
        return math.floor((sum1 / sum2) * 65536)
    except:
        return 65536