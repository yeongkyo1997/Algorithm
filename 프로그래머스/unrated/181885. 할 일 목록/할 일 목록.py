def solution(todo_list, finished):
    result = []
    
    for i, ele in enumerate(todo_list):
        if not finished[i]:
            result.append(ele)
        
    return result
            