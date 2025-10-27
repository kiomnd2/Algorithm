def solution(babbling):
    answer = 0
    canSpeak = ("aya", "ye", "woo", "ma")
    
    for bab in babbling :
        flag = True
        for speak in canSpeak :
            if speak*2 not in bab and speak in bab :
                bab = bab.replace(speak, ' ')
            
        if bab.isspace() : answer += 1
    
    return answer