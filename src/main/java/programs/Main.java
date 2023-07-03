package programs;// A Java program generate a random AlphaNumeric String
// using Regular Expressions method

import java.nio.charset.Charset;
import java.util.Random;

class Main {
    public String getAlphaNumericString(int n, int lines,int bytes)
    {
// length declaration
        byte[] array = new byte[bytes];
        String AlphaNumericString =  null;
        StringBuffer ra = new StringBuffer();;
        for(int i = 0;i<lines ; i++) {
            int stringLength = n;
            new Random().nextBytes(array);
            String randomString
                    = new String(array, Charset.forName("UTF-8"));
            //System.out.println(randomString);
// Creating a StringBuffer

// remove all spacial char
            AlphaNumericString
                    = randomString
                    .replaceAll("[^A-Za-z]", "");


            //System.out.println(AlphaNumericString);
            for (int k = 0; k < AlphaNumericString.length(); k++) {
                if (Character.isLetter(AlphaNumericString.charAt(k))
                        && (stringLength > 0)
                        || Character.isDigit(AlphaNumericString.charAt(k))
                        && (stringLength > 0)) {
                    ra.append(AlphaNumericString.charAt(k));
                    stringLength--;
                }
            }
            ra.append("\n");
        }
// Append first 20 alphanumeric characters
// from the generated random String into the result

// returning the resultant string
        return ra.toString();
    }
    public static void main(String[] args)
    {
// size of random alphanumeric string
        int n = 20;
// Get and display the alphanumeric string
        //System.out.println(getAlphaNumericString(n,2,128));
    }
}