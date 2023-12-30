def solution(sides):
    sides = sorted(sides)
    a = sides.pop()
    
    if a < sum(sides):
        return 1
    else:
        return 2