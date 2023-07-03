package programs;

import java.util.*;
class LonelyIntegerResult {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        int count=0;
        for(int num:a){
            if(a.size()==1){
                return num;
            }
            for(int i=0;i<a.size();i++){
                if(a.indexOf(num)!=i){
                    if(num==a.get(i))
                    {
                        count+=1;
                        int index=a.indexOf(num);
                        a.remove(index);
                        a.remove(i);
                        break;
                    }
                }
            }
            if (count==0) {
                a.remove(0);
                lonelyinteger(a);
                System.out.println(num);
                return num;
            }
            else
                count=0;
         }
        return 0;
    }

}