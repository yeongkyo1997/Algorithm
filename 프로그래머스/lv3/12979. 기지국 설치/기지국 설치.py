def solution(n, stations, w):
    answer = 0
    sq = []
    for s in stations:
        sq.append(s)
    position = 1
    while position <= n:
        if len(sq) > 0 and position >= sq[0] - w:
            position = sq.pop(0) + w + 1
        else:
            answer += 1
            position += w * 2 + 1
    return answer