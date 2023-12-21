def solution(players, callings):
    player_positions = {player: i for i, player in enumerate(players)}

    for calling in callings:
        pos = player_positions[calling]
        players[pos-1], players[pos] = players[pos], players[pos-1]
        player_positions[players[pos]] = pos
        player_positions[calling] = pos-1

    return players

