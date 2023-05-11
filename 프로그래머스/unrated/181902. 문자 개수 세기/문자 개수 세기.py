def solution(my_string):
    return [my_string.count(chr(i)) for i in range(65, 91)] + [my_string.count(chr(i)) for i in range(97, 123)]
