def solution(absolutes, signs):
    return sum(map(lambda x, y : x if y else -x, absolutes, signs))