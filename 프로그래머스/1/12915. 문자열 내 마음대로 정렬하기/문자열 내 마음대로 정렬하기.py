def solution(strings, n):
    answer = []
    
    strings.sort()
    strings.sort(key= lambda p : p[n] )
    
    
    return strings