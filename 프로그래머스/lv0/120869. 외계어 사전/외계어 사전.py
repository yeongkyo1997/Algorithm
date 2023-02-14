def solution(spell, dic):
    spell = "".join(sorted(spell))
    dic = list(map(lambda x: "".join(sorted(x)), dic))
    if spell in dic:
        return 1
    else:
        return 2