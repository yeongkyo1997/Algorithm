def solution(dots):
    combinations = [(0, 1, 2, 3), (0, 2, 1, 3), (0, 3, 1, 2)]
    for comb in combinations:
        x1, y1 = dots[comb[0]]
        x2, y2 = dots[comb[1]]
        x3, y3 = dots[comb[2]]
        x4, y4 = dots[comb[3]]
        
        slope1 = (y2 - y1) / (x2 - x1)
        slope2 = (y4 - y3) / (x4 - x3)
        
        if slope1 == slope2:
            return 1 
    return 0

