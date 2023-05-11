import sys

sys.setrecursionlimit(20000)


def find_empty_room(number, rooms): 
    if number not in rooms:
        rooms[number] = number + 1
        return number

    empty = find_empty_room(rooms[number], rooms)
    rooms[number] = empty + 1
    return empty

def solution(k, room_number):
    answer = []
    rooms = dict()  
    for number in room_number:
        empty_room = find_empty_room(number, rooms)
        answer.append(empty_room)

    return answer
