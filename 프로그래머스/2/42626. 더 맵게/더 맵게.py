import heapq

def solution(scoville, K):
    heap = scoville[:]
    heapq.heapify(heap)
    result = 0
    while heap:
        if heap[0] >= K:
            return result
        
        first = heapq.heappop(heap)
        second = 0
        if heap:
            second = heapq.heappop(heap)
        else:
            return -1
        result += 1
        heapq.heappush(heap, first + second * 2)
