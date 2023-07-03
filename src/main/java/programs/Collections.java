package programs;

import java.util.HashSet;

public class Collections {
    public static void main(String[] args) {
        HashSetClass hashSetClass = new HashSetClass();
        HashSet<String> h_set = hashSetClass.hashSetProgram();
        hashSetClass.hashSetProgramIterate(h_set);
        ListPrograms listPrograms = new ListPrograms();
        listPrograms.collectionProgram();
    }
}