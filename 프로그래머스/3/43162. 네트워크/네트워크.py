def solution(n, computers):
    def dfs(current, visited, computers, n):
        visited[current] = True
        for neighbor in range(n):
            if computers[current][neighbor] == 1 and not visited[neighbor]:
                dfs(neighbor, visited, computers, n)
    
    visited = [False] * n
    answer = 0
    
    for i in range(n):
        if not visited[i]:
            dfs(i, visited, computers, n)
            answer += 1
            
    return answer