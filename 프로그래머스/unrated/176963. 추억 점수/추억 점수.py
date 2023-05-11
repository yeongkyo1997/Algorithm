def solution(name, yearning, photo):
    yearning_dict = {}
    for i in range(len(name)):
        yearning_dict[name[i]] = yearning[i]
    
    answer = []
    for p in photo:
        score = 0
        for n in p:
            if n in yearning_dict:
                score += yearning_dict[n]
        answer.append(score)
    
    if not answer:
        return ["EMPTY"]
    else:
        return answer
