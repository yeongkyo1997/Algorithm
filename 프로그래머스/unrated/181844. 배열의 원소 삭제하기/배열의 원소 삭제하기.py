def solution(arr, delete_list):
    result = []
    
    for i in arr:
        if not i in delete_list:
            result.append(i)
    
    return result