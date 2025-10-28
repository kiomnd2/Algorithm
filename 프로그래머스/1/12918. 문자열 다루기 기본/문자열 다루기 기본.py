def solution(s):
    answer = True
    
    if len(s) != 4 and len(s) != 6 :
        return False
    
    for str in s :
        if not str.isnumeric() :
            answer = False
    
    return answer