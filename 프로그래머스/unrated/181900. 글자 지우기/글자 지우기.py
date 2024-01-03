def solution(my_string, indices):
    return ''.join(ele for i, ele in enumerate(my_string) if not i in indices)