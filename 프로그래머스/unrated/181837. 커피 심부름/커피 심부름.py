def solution(order):
    return sum(4500 if 'america' in i else 5000 if 'cafelatte' in i else 4500 for i in order)
