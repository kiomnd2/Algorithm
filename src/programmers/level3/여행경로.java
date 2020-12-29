

import java.util.*;

public class 여행경로 {

        public static void main(String[] args) {

//            String[][] arr = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" } };
//            String[][] arr = {{ "ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//            String[][] arr = {{ "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" }};
//            String[][] arr = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "BCN" } };
//            String[][] arr = {{"ICN", "COO"}, {"ICN", "BOO"}, {"ICN", "AOO"}};
//            String[][] arr = {{"ICN", "COO"}, {"ICN", "COO"}, {"ICN", "AOO"}};
//            String[][] arr = {{"ICN", "BOO"},{"BOO", "ICN"},{"BOO", "BCN"}};
            String[][] arr = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" },{ "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
//
            String[] rslt = solution(arr);
            for(int i =0; i< rslt.length; i++)
            {
                System.out.println(rslt[i]);
            }
        }

        //[[ICN, JFK], [HND, IAD], [JFK, HND]] [ICN, JFK, HND, IAD]
    //[[ICN, SFO], [ICN, ATL], [SFO, ATL], [ATL, ICN], [ATL,SFO]] [ICN, ATL, ICN, SFO, ATL, SFO]
    public static String[] solution(String[][] tickets)
    {
        String[] answer;
        boolean[] visited = new boolean[tickets.length];
        ArrayList<String> result = new ArrayList<>();

        for(int i =0; i < tickets.length; i++)
        {
            //출발지 먼저 찾음
            if("ICN".equals(tickets[i][0]))
            {
                ArrayList<String> tempArr = new ArrayList<>();
                tempArr.add("ICN");
                visited[i] = true;
                recursive(tickets ,visited ,i ,tempArr, result);
                visited[i] = false;
            }
        }

/*        //정렬 ..
        Collections.sort(result, (o1, o2) -> {
            for(int i =0 ; i < o1.size() ; i++)
            {
                if( o1.get(i).compareTo(o2.get(i)) > 0 )
                {
                    return 1;
                }
            }
            return -1;
        });*/


        answer = Arrays.copyOf(result.toArray(), result.size(), String[].class );

        return answer;
    }

    public static void recursive(String[][] tickets, boolean[] visited, int n, ArrayList<String> visitedNode, ArrayList<String> result)
    {
        //다음 목적지에 해당하는 배열을 찾음
        String dest = tickets[n][1];
        visitedNode.add(dest);
        for(int i =0; i< tickets.length ; i++)
        {
            //방문하지 않은곳이고.. 목적지와 일치하는 출발지
            if( !visited[i] && dest.equals(tickets[i][0]))
            {
                //방문으로 바꾸고
                visited[i] = true;

                recursive(tickets,Arrays.copyOf(visited,visited.length) , i, new ArrayList<>(visitedNode), result);

            }
        }


        System.out.println(visitedNode);
        //기존에 결과가 있을때 ..
        if(result.size() != 0 )
        {
            //기존에 있던 결과가 지금 치고들어온 결과보다 클 때
            if(visitedNode.size() > result.size())
            {
                result.clear();
                result.addAll(visitedNode); //그냥 바꿔
            }
            else if( visitedNode.size() == result.size() )//작은건 볼 필요도 없고 같을경우만 봄
            {
                System.out.println("################");
                System.out.println("visited: "+visitedNode);
                System.out.println("result : "+result);

                //한자한자 비교해보자
                for(int i =0; i< visitedNode.size() ; i++)
                {

                    String curNode = visitedNode.get(i);
                    String preNode= result.get(i);
                    //같지 않을때가 크기 가르기 포인트다
                    if(!curNode.equals( preNode) && curNode.compareTo(preNode) < 0 )
                    {
                        System.out.println(curNode);
                        System.out.println(preNode);
                        result.clear();
                        result.addAll(visitedNode);
                        break;
                    }
                    else if(!curNode.equals( preNode) && curNode.compareTo(preNode) > 0 )
                    {
                        break;
                    }
                }
            }
        }
        else {
            result.addAll(visitedNode);
        }
    }
}
