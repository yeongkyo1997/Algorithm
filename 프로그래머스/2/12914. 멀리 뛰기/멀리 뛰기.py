from collections import defaultdict

def solution(n):
    lib = defaultdict(int)
    
    lib[1] = 1
    lib[2] = 2
    
    for i in range(3, n + 1):
        lib[i] = lib[i - 1] + lib[i - 2]
    
    return lib[n] % 1234567
    