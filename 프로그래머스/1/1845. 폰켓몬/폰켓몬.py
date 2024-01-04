from collections import defaultdict, Counter
def solution(nums):
    size = len(nums) // 2
    lib = defaultdict(int)
    counter = Counter(nums)
    
    for key, val in counter.items():
        lib[key] = val
        
    return min(len(lib.keys()), len(nums) // 2)