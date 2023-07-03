package programs;

import java.util.*;

class ResultMatchingString {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> answer=new ArrayList<>();
        int count=0;
        for(String query:queries) {
            for (String string : strings) {
                if (query.equals(string))
                    count = count + 1;
            }
           answer.add(count);
            count=0;
        }
        return answer;

    }

}