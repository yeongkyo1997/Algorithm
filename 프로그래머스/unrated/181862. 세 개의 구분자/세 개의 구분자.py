def solution(myStr):
    result = []
    temp = ""
    for char in myStr:
        if char in ["a", "b", "c"]:
            if temp:
                result.append(temp)
            temp = ""
        else:
            temp += char
    if temp:
        result.append(temp)
    if not result:
        return ["EMPTY"]
    return result
