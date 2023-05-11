def solution(cards1, cards2, goal):
    i, j, k = 0, 0, 0
    while k < len(goal):
        if i < len(cards1) and goal[k] == cards1[i]:
            i += 1
        elif j < len(cards2) and goal[k] == cards2[j]:
            j += 1
        else:
            return "No"
        k += 1

    return "Yes"

