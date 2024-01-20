from collections import deque

def solution(cacheSize, cities):
    cache = deque(maxlen=cacheSize)
    result = 0
    
    for i in cities:
        i = i.lower()
        if i in cache:
            cache.remove(i)
            cache.append(i)
            result += 1
        else:
            cache.append(i)
            result += 5
    return result