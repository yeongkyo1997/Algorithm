def solution(s):
    num = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for i, alpha in enumerate(num):
        try:
            s = s.replace(alpha, str(i))
        except:
            pass
        
    return int(s)