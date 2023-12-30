def solution(answers):
    st_1 = [1, 2, 3, 4, 5]
    st_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    st_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    st_lib = {
        1:0,
        2:0,
        3:0
    }
    
    for i, ele in enumerate(answers):
        if ele == st_1[i % len(st_1)]:
            st_lib[1] += 1
        if ele == st_2[i % len(st_2)]:
            st_lib[2] += 1
        if ele == st_3[i % len(st_3)]:
            st_lib[3] += 1
            
    max_score = max(st_lib.values())
    
    result = []
    for i in range(1, 4):
        if max_score == st_lib[i]:
            result.append(i)
    return result
        