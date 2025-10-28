def solution(a, b):
    answer = 0
    
    if (a > b) :
        a, b = b,a
    
    sum =0
    for i in range(a,b+1) :
        sum += i
    return sum