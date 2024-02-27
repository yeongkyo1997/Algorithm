def solution(bandage, health, attacks):
    t, x, y = bandage 
    cur_health = health
    cont = 0
    last_attacks = 0 if not attacks else attacks[-1][0]

    for second in range(last_attacks + 1):
        attack = next((a for a in attacks if a[0] == second), None)

        if attack:
            cur_health -= attack[1]  
            cont = 0  
            if cur_health <= 0:  
                return -1  
        else:
            cur_health += x
            cont += 1
            if cur_health > health:
                cur_health = health
            if cont == t:
                cur_health += y
                cont = 0 
                if cur_health > health:
                    cur_health = health

    return cur_health
