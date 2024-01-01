def solution(myString, pat):
    ch_string = ''.join('A' if i == 'B' else 'B' for i in myString)
    
    return 1 if pat in ch_string else 0