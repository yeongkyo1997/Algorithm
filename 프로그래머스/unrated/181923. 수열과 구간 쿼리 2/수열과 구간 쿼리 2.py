def solution(arr, queries):
    answer = []
    for q in queries:
        s, e, k = q
        min_value = float('inf')
        for i in range(s, e+1):
            if arr[i] > k and arr[i] < min_value:
                min_value = arr[i]
        if min_value == float('inf'):
            answer.append(-1)
        else:
            answer.append(min_value)
    return answer
