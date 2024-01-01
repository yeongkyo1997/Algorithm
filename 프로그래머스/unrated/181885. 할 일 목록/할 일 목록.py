def solution(todo_list, finished):
    result = []
    
    return [ele for i, ele in enumerate(todo_list) if not finished[i]]
