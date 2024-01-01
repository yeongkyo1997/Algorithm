def solution(num_list):
    odd_sum = 0
    even_sum = 0
    
    for i, ele in enumerate(num_list):
        if i % 2 == 0:
            even_sum += ele
        else:
            odd_sum += ele
    return max(even_sum, odd_sum)

