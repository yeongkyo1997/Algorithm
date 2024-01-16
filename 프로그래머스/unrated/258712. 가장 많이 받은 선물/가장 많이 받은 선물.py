from collections import defaultdict

def solution(friends, gifts):
    friends_lib = {friend : idx for idx, friend in enumerate(friends)}
    board = [[0] * len(friends) for _ in range(len(friends))]
    
    get_gift = defaultdict(int)
    for gift in gifts:
        give, recive = gift.split()
        
        board[friends_lib[give]][friends_lib[recive]] += 1
    
    def cnt(num):
        give, recive = 0, 0
        for i in range(len(friends)):
            give += board[num][i]
            recive += board[i][num]
        
        return give - recive
    
    for i in range(len(friends)):
        for j in range(len(friends)):
            if i == j:
                continue
            else:
                if board[i][j] > board[j][i]:
                    get_gift[i] += 1
                elif board[i][j] == board[j][i]:
                    if cnt(i) > cnt(j):
                        get_gift[i] += 1

    if get_gift:
        return max(get_gift.values())
    else:
        return 0