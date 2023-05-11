from queue import PriorityQueue

def solution(x, y, n):
    if x == y:  
        return 0

    visited = set()  
    q = PriorityQueue()  

    q.put((0, x))  

    while not q.empty():
        cnt, num = q.get()  

        if num == y: 
            return cnt

        if num not in visited:  
            visited.add(num)

            if num + n <= y:
                q.put((cnt+1, num+n))
            if num * 2 <= y: 
                q.put((cnt+1, num*2))
            if num * 3 <= y:  
                q.put((cnt+1, num*3))

    return -1  
