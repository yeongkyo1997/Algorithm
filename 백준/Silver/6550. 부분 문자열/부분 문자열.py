def is_subsequence(s, t):
    s_idx, t_idx = 0, 0
    while s_idx < len(s) and t_idx < len(t):
        if s[s_idx] == t[t_idx]:
            s_idx += 1 
        t_idx += 1  
    return s_idx == len(s)  


while True:
    try:
        s, t = input().split()
        if is_subsequence(s, t):
            print('Yes')
        else:
            print('No')
    except:
        break