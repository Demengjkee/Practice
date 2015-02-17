package Program;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by demeng on 15.02.15.
 */
public class Program {
    public static void main(String[] args) throws IOException{
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        final ArrayList<Juice> juices = new ArrayList<Juice>();
        while(sc.hasNext()){
            Juice read = new Juice(sc.nextLine());
            juices.add(read);
        }

        Collections.sort(juices, new Comparator<Juice>() {
            @Override
            public int compare(Juice o1, Juice o2) {
                return o1.getComponentsNumber() - o2.getComponentsNumber();
            }
        });

        Stack<Juice> juiceStack = Methods.getStack(juices);
        for(Juice x : juiceStack){
            for(String y : x.getComponents())
                System.out.println(y);
            System.out.println();
        }
        int cleanings = 1;

        Juice[] juiceSortArray = new Juice[juiceStack.size()];
        juiceStack.copyInto(juiceSortArray);
        for(int i = 0;i < juiceSortArray.length - 1;i++){
            Juice prev = juiceSortArray[i];
            Juice next = juiceSortArray[i + 1];
            if(prev.getComponentsNumber() >= next.getComponentsNumber())
                cleanings++;
        }

        System.out.println("Number of cleanings: " + cleanings);
    }
}
