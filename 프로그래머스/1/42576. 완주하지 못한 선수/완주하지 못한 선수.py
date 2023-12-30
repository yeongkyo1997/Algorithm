from collections import defaultdict

def solution(participant, completion):
    lib = defaultdict(int)
    
    for c in completion:
        lib[c] += 1
        
    for p in participant:
        lib[p] -= 1
        
    for key, value in lib.items():
        if value < 0:
            return key