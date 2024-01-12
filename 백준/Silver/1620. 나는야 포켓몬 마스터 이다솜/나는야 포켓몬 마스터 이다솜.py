import sys


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
pokemon_dict = {} 
pokemon_list = []  

for i in range(1, N + 1):
    name = input().rstrip()
    pokemon_dict[name] = i
    pokemon_list.append(name)

for _ in range(M):
    question = input()
    if question.isdigit(): 
        print(pokemon_list[int(question) - 1])
    else:  
        print(pokemon_dict[question])