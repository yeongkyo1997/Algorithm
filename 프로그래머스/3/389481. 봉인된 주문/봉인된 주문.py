from bisect import bisect_left, bisect_right

def solution(n, bans):
    max_length = 11
    
    banned_by_length = {l: [] for l in range(1, max_length+1)}
    for s in bans:
        banned_by_length[len(s)].append(s)
    for l in banned_by_length:
        banned_by_length[l].sort()
    
    pow26 = [1] * (max_length + 1)
    for i in range(1, max_length+1):
        pow26[i] = pow26[i-1] * 26
    
    chosen_length = None
    for L in range(1, max_length+1):
        total = pow26[L] 
        banned_count = len(banned_by_length[L])
        valid_count = total - banned_count 
        if n > valid_count:
            n -= valid_count
        else:
            chosen_length = L
            break
    if chosen_length is None:
        return ""
    
    banned_list = banned_by_length[chosen_length]
    
    def count_banned(prefix):
        lo = bisect_left(banned_list, prefix)
        hi = bisect_left(banned_list, prefix + '{')
        return hi - lo

    result = ""
    for i in range(chosen_length):
        for ch in "abcdefghijklmnopqrstuvwxyz":
            candidate_prefix = result + ch
            total_completions = pow26[chosen_length - len(candidate_prefix)]
            banned_num = count_banned(candidate_prefix)
            valid_completions = total_completions - banned_num
            if valid_completions >= n:
                result = candidate_prefix
                break
            else:
                n -= valid_completions
    return result
