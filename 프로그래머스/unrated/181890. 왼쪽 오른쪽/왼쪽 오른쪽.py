def solution(str_list):
    if "l" not in str_list and "r" not in str_list:
        return []
    
    first_l = str_list.index("l") if "l" in str_list else float('inf')
    first_r = str_list.index("r") if "r" in str_list else float('inf')
    
    if first_l < first_r:
        return str_list[:first_l]
    else:
        return str_list[first_r + 1:]
