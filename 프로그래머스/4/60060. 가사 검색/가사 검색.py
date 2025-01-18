from bisect import bisect_left, bisect_right
from collections import defaultdict

def solution(words, queries):
    
    word_dict = defaultdict(list)
    reversed_word_dict = defaultdict(list)
    for word in words:
        word_len = len(word)
        word_dict[word_len].append(word)
        reversed_word_dict[word_len].append(word[::-1])  

    
    for length in word_dict:
        word_dict[length].sort()
        reversed_word_dict[length].sort()

    answer = []
    cache = {}

    for query in queries:
        if query in cache:
            
            answer.append(cache[query])
            continue

        q_len = len(query)
        if q_len not in word_dict:
            
            cache[query] = 0
            answer.append(0)
            continue

        if query[0] != '?':
            
            key = query.replace('?', '')
            left = bisect_left(word_dict[q_len], query.replace('?', 'a'))
            right = bisect_right(word_dict[q_len], query.replace('?', 'z'))
            count = right - left
        else:
            
            reversed_query = query[::-1]
            
            fixed_part = reversed_query.replace('?', '')
            left = bisect_left(reversed_word_dict[q_len], fixed_part)
            right = bisect_right(reversed_word_dict[q_len], fixed_part + '{')  
            count = right - left

        cache[query] = count
        answer.append(count)

    return answer