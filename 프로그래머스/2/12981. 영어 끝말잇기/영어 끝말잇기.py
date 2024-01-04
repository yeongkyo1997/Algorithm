def solution(n, words):
    memo = []
    memo.append(words[0])
    
    for i in range(1, len(words)):
        if words[i] in memo or words[i - 1][-1] != words[i][0] or len(words[i]) == 1:
            return [ i % n + 1, i // n + 1]
        memo.append(words[i])
        
    return [0, 0]
            