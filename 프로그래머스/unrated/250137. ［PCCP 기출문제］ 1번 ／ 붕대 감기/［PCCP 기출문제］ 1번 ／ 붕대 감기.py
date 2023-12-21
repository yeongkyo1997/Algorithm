def solution(bandage, health, attacks):
    t, x, y = bandage
    current_health = health
    attack_dict = {attack[0]: attack[1] for attack in attacks}
    continuous_success = 0
    time = 0

    while time <= max(attack_dict.keys(), default=0):
        if time in attack_dict:
            current_health -= attack_dict[time]
            continuous_success = 0
            if current_health <= 0:
                return -1
        else:
            current_health = min(health, current_health + x)
            continuous_success += 1
            if continuous_success == t:
                current_health = min(health, current_health + y)
                continuous_success = 0

        time += 1

    return current_health

