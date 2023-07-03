package programs;

import java.util.*;

public class HashSetClass{

    public HashSet<String> hashSetProgram() {
        // Create a empty hash set
        HashSet<String> h_set = new HashSet<String>();
        // use add() method to add values in the hash set
        h_set.add("Red");
        h_set.add("Green");
        h_set.add("Black");
        h_set.add("White");
        h_set.add("Pink");
        h_set.add("Yellow");

        // print the hash set
        System.out.println("The Hash Set: " + h_set);

        return h_set;

    }

    public void hashSetProgramIterate(HashSet<String> h_set){
       // set Iterator
        Iterator<String> p = h_set.iterator();
        // Iterate the hash set
        while (p.hasNext()) {
            System.out.println(p.next());
        }
    }

        public void hashSetProgramRemoveAll(){


        }
    }
