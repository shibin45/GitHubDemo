package programs;

import java.math.BigDecimal;
import java.util.List;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */


    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double countNeg=0,countPos=0,countZero=0,countAll=0;
        double negFrac=0,posFrac=0,zeroFrac=0;
        for(int num:arr) {
            //System.out.print(num+"\t");
            if (num>0)
            {
                //System.out.print("positive");
                countPos++;
            }
            else if (num<0)
            {
                //System.out.print("Negative");
                countNeg++;
            }
            else{
                //System.out.print("Zero");
                countZero++;
            }
        }
        //System.out.println(countPos);
        countAll=countNeg+countPos+countZero;

        if(countNeg>0){
            System.out.println(countZero);
            negFrac=countNeg/countAll;

        }

        if(countPos>0){
            posFrac=countPos/countAll;
        }
        if(countZero>0){
            zeroFrac=countZero/countAll;
        }

        System.out.println(new BigDecimal(posFrac).setScale(6,2));
        System.out.println(new BigDecimal(negFrac).setScale(6,3));
        System.out.println(new BigDecimal(zeroFrac).setScale(6,2));
    }
}

