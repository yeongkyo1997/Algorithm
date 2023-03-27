def solution(before, after):
    if ''.join(sorted(list(before))) == ''.join(sorted(list(after))):
        return 1
    else:
        return 0
