from collections import defaultdict
from bisect import bisect_left, bisect_right

def count_by_range(array, left_value, right_value):
    left_index = bisect_left(array, left_value)
    right_index = bisect_right(array, right_value)
    return right_index - left_index

def solution(words, queries):
    word_dict = defaultdict(list)
    reversed_word_dict = defaultdict(list)
    for word in words:
        word_dict[len(word)].append(word)
        reversed_word_dict[len(word)].append(word[::-1])
    for key in word_dict.keys():
        word_dict[key].sort()
        reversed_word_dict[key].sort()
    
    answer = []
    for query in queries:
        if query[0] != '?':
            result = count_by_range(word_dict[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
        else:
            result = count_by_range(reversed_word_dict[len(query)], query[::-1].replace('?', 'a'), query[::-1].replace('?', 'z'))
        answer.append(result)
    return answer
