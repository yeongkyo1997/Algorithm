import heapq
import math

def solution(k, score):
    heap = []
    
    result = []
    
    for i, ele in enumerate(score):
        if i < k:
            heapq.heappush(heap, ele)
        else:
            if ele > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, ele)
        result.append(heap[0])
    
    return result