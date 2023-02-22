from itertools import zip_longest


def solution(msg):
    result = []
    dic = {chr(64 + i): i for i in range(1, 27)}

    idx = 0
    depth = 27
    while True:
        w = msg[idx]
        try:
            c = msg[idx + 1]
        except:
            result.append(dic[w])
            return result

        while w + c in dic:
            w += c
            idx += 1
            try:
                c = msg[idx + 1]
            except:
                result.append(dic[w])
                return result
        dic[w + c] = depth
        result.append(dic[w])
        idx += 1
        depth += 1

    return result