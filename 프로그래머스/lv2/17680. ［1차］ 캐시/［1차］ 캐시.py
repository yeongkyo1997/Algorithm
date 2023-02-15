from collections import deque


def solution(cacheSize, cities):
    result = 0
    cache = deque()
    cities = [i.lower() for i in cities]

    for i, x in enumerate(cities):
        if x in cache:
            result += 1
            cache.remove(x)
            cache.append(x)
        else:
            result += 5
            if len(cache) == cacheSize:
                try:
                    cache.popleft()
                    cache.append(x)
                except:
                    pass
            else:
                cache.append(x)
    return result