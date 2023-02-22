def solution(s):
    dic = dict.fromkeys(list(s), -1)
    result = []
    for i in range(len(s)):
        if dic[s[i]] == -1:
            result.append(-1)
        else:
            result.append(i - dic[s[i]])
        dic[s[i]] = i
    return result