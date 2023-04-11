import sys

input = lambda: sys.stdin.readline().rstrip()


def solution(players, callings):
    answer = []
    for i in range(len(callings)):
        answer.append(callings[i])
        for j in range(i + 1, len(callings)):
            if callings[i] == callings[j]:
                answer.pop()
                break

    for i in range(len(players)):
        if players[i] not in answer:
            answer.append(players[i])

    return answer


print(solution(["mumu", "soe", "poe", "kai", "mine"],
               ["kai", "kai", "mine", "mine"]))  # ["mumu", "kai", "mine", "soe", "poe"]
