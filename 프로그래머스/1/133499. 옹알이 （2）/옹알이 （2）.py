def solution(babbling):
    result = 0
    can = ['aya', 'ye', 'woo', 'ma']
    cant = [c * 2 for c in can]

    
    for bab in babbling:
        for c in cant:
            if c in bab:
                break
        else:
            while bab:
                tmp = bab[:]
                for c in can:
                    if bab[:len(c)] == c:
                        bab = bab[len(c):]
                if tmp == bab:
                    break
            else:
                result += 1
                
    return result