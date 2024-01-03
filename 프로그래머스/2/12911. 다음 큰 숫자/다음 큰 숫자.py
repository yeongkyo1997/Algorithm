def solution(n):
    cnt = bin(n).count('1')
    
    for i in range(n + 1, 1000001):
        b = bin(i)
        if cnt == bin(i).count('1'):
            return int(bin(i)[2:], 2)
        