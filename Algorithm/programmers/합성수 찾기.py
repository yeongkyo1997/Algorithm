def solution(n):
    return len([i for i in range(2, n + 1) if not all(i % j for j in range(2, i))])
