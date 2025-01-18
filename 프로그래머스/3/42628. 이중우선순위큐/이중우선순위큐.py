import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    
    
    count_map = {}
    
    def add_num(num):
        
        heapq.heappush(min_heap, num)
        heapq.heappush(max_heap, -num)  
        count_map[num] = count_map.get(num, 0) + 1
    
    def remove_min():
        
        while min_heap:
            num = heapq.heappop(min_heap)
            if count_map.get(num, 0) > 0:
                
                count_map[num] -= 1
                if count_map[num] == 0:
                    del count_map[num]
                break  
    
    def remove_max():
        
        while max_heap:
            num = -heapq.heappop(max_heap)
            if count_map.get(num, 0) > 0:
                count_map[num] -= 1
                if count_map[num] == 0:
                    del count_map[num]
                break
    
    for op in operations:
        command, val = op.split()
        val = int(val)
        
        if command == 'I':
            add_num(val)
        else:
            if not count_map:
                
                continue
            if val == 1:
                remove_max()
            else:  
                remove_min()
    
    
    
    if not count_map:
        return [0, 0]
    
    
    max_val = None
    while max_heap and max_val is None:
        candidate = -max_heap[0]
        if count_map.get(candidate, 0) > 0:
            max_val = candidate
        else:
            
            heapq.heappop(max_heap)
    
    
    min_val = None
    while min_heap and min_val is None:
        candidate = min_heap[0]
        if count_map.get(candidate, 0) > 0:
            min_val = candidate
        else:
            
            heapq.heappop(min_heap)
    
    
    if max_val is None or min_val is None:
        return [0, 0]
    else:
        return [max_val, min_val]
