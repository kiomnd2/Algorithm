def solution(s):
    answer = True
    pCount = 0
    yCount = 0
    
    for str in s :
        upps = str.upper();
        if upps == 'P' :
            pCount+=1
        elif upps == 'Y' :
            yCount+=1
            
    if yCount == pCount :
        return True

    return False