package leetcode.p84;

import java.util.Arrays;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        //[2,1,5,6,2,3].
//        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));
//        System.out.println(largestRectangleArea(new int[]{1,1}));
//        System.out.println(largestRectangleArea(new int[]{1}));
//        System.out.println(largestRectangleArea(new int[]{0}));
//        System.out.println(largestRectangleArea(new int[]{2,1,2}));


    }

    public static int largestRectangleArea(int[] heights)
    {
        int ans = 0 ;

        for(int i =0 ; i < heights.length ; i++)
        {
            int height = heights[i];
            int col = 0;
            int curMax = 0;
            for(int j = i ; j < heights.length ; j ++ )
            {
                int nextHeight = heights[j];
                if(height <= nextHeight)
                {
                    col++;

                    curMax = col* height;
                    //System.out.println("col = " +col + " height = "+ height +" ans = " + curMax);
                }
                else
                {
                    //nextHeight에 대해 추가계산.. 재귀 돌린다.
                    //파라미터는 nextHeight 의 높이와 현재 스퀘어의 인덱스
//                    System.out.println(subLargestRectangleArea(heights, curMax, nextHeight, i));
                    curMax = Math.max(curMax , subLargestRectangleArea(heights, curMax, nextHeight, i));
//                    System.out.println("col = " +col + " height = "+ nextHeight +" ans = " + curMax);
                    break;
                }
            }
            if(curMax >= ans)
            {
                ans = curMax;
            }

        }

        return ans;
    }
    public static int subLargestRectangleArea(int[] heights, int max, int height, int i)
    {
        int res = 0;
        int col = 0 ;
        for(int j =i ; j < heights.length ; j++)
        {
            int nextHeight = heights[j];
            if(height <= nextHeight)
            {
                col++;
                res = height * col;
            }
            else
            {
                res = Math.max(res, subLargestRectangleArea(heights, res, nextHeight, i));
//                System.out.println("col = " +col + " height = "+ height +" ans = " + res);
                break;
            }
        }
        return res;
    }
}
