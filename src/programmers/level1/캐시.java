import java.util.ArrayList;

public class 캐시 {
    public static void main(String[] args) {


        //3	[Jeju, Pangyo, Seoul, NewYork, LA, Jeju, Pangyo, Seoul, NewYork, LA]	50
        //3	[Jeju, Pangyo, Seoul, Jeju, Pangyo, Seoul, Jeju, Pangyo, Seoul]	21
        //2	[Jeju, Pangyo, Seoul, NewYork, LA, SanFrancisco, Seoul, Rome, Paris, Jeju, NewYork, Rome]	60
        //5	[Jeju, Pangyo, Seoul, NewYork, LA, SanFrancisco, Seoul, Rome, Paris, Jeju, NewYork, Rome]	52
        //2	[Jeju, Pangyo, NewYork, newyork]	16
        //0	[Jeju, Pangyo, Seoul, NewYork, LA]	25
        int cacheSize =3;
        String[] ciies = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
        System.out.println(solution(cacheSize, ciies));
    }
    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();

        for( int i =0 ; i< cities.length; i++)
        {

            String city = cities[i].toLowerCase();
            if (cacheSize == 0) {
                answer+=5;
            }
            else
            {
                if(!cache.contains(city)) // cache miss
                {
                    if(cacheSize != 0 && cacheSize == cache.size())
                    {
                        cache.remove(0); // 앞에서부터 자름
                    }
                    cache.add(city);
                    answer+=5;
                }
                else // cache hit
                {
                    //캐시 히트한거 맨 앞으로 올림
                    int idx = cache.indexOf(city);
                    cache.add(city);
                    cache.remove(idx);
                    answer+=1;
                }
            }

        }
        return answer;
    }
}
