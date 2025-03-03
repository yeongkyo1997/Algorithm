from itertools import combinations

def solution(n, q, ans):
    answer = 0
    
    for candidate in combinations(range(1, n+1), 5):
        valid = True
        candidate_set = set(candidate)
        for i, attempt in enumerate(q):
            if len(candidate_set.intersection(attempt)) != ans[i]:
                valid = False
                break
        if valid:
            answer += 1
    
    return answer
