package programs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPrograms{
    public void collectionProgram(){
        int i =0;
        List<String> list_Strings = new ArrayList<String>();
        list_Strings.add("Red");
        list_Strings.add("Green");
        list_Strings.add("Orange");
        list_Strings.add("White");
        list_Strings.add("Black");
        Iterator it = list_Strings.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while(it.hasNext())
        {
            System.out.println(i++);
            it.next();
        }
        for(String colour : list_Strings)
        {
            System.out.println(colour);
            stringBuilder.append(colour);
            stringBuilder.reverse();
        }
        System.out.println(stringBuilder);
    }
}
