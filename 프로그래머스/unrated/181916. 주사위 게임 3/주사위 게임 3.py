def solution(a, b, c, d):
    dice = [a, b, c, d]
    unique_counts = {}
    
    for num in dice:
        if num in unique_counts:
            unique_counts[num] += 1
        else:
            unique_counts[num] = 1
            
    unique_numbers = len(unique_counts)
    
    if unique_numbers == 1:
        p = list(unique_counts.keys())[0]
        return 1111 * p
    elif unique_numbers == 2:
        if any(count == 3 for count in unique_counts.values()):
            p, q = unique_counts.keys()
            if unique_counts[p] == 1:
                p, q = q, p
            return (10 * p + q) ** 2
        else:
            p, q = unique_counts.keys()
            return (p + q) * abs(p - q)
    elif unique_numbers == 3:
        p = next(num for num, count in unique_counts.items() if count == 2)
        q, r = (num for num, count in unique_counts.items() if count == 1)
        return q * r
    else:
        return min(dice)
