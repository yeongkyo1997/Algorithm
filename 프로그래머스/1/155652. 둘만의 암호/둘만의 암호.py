def solution(s, skip, index):
    result = ''
    skip_list = [ord(i) for i in skip]
    
    alpha_list = [chr(i) for i in range(ord('a'), ord('z') + 1) if not i in skip_list]
    for ele in s:
        result += alpha_list[(alpha_list.index(ele) + index) % (len(alpha_list))]
    return result
        