package programs;

import java.util.*;
class FindSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long minSum=0,maxSum=0,sum;
        for(int number: arr)
        {
            minSum=minSum+number;
        }
        for(int number: arr){
            sum=0;
            for(int i=0;i<arr.size();i++)
            {
                //if(number==arr.get(i) && i==arr.indexOf(number))
                if(i==arr.indexOf(number))
                {
                    continue;
                }
                else{
                    sum=sum+arr.get(i);
                }
            }
            if(sum<minSum)
            {
                minSum=sum;
            }
            if (sum>maxSum)
            {
                maxSum=sum;
            }
        }
        System.out.println(minSum);
        System.out.println(maxSum);
    }
}