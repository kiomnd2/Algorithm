import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public int solution(int cacheSize, String[] cities) {
    if (cacheSize == 0) return cities.length * 5;
    
    int time = 0;
    Deque<String> cache = new ArrayDeque<>();
    
    for (String city : cities) {
        String normalizedCity = city.toLowerCase();
        
        if (cache.contains(normalizedCity)) {
            // 캐시 히트: 해당 요소를 제거하고 맨 앞으로
            cache.remove(normalizedCity);
            cache.addFirst(normalizedCity);
            time += 1;
        } else {
            // 캐시 미스
            if (cache.size() >= cacheSize) {
                cache.removeLast();
            }
            cache.addFirst(normalizedCity);
            time += 5;
        }
    }
    
    return time;
}
}