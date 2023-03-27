import collections


def solution(numbers, direction):
    q = collections.deque()
    q.extend(numbers)
    if direction == 'left':
        q.rotate(-1)
    else:
        q.rotate(1)
    return list(q)
