package Program;

import java.util.*;

/**
 * Created by demeng on 15.02.15.
 */
public class Methods {
    public static int compare(Juice o1, Juice o2) {
        ArrayList<String> juiceBigger = (o1.getComponents().size() >= o2.getComponents().size()?
                o1.getComponents() : o2.getComponents());
        ArrayList<String> juiceSmaller = (o1.getComponents().size() < o2.getComponents().size()?
                o1.getComponents() : o2.getComponents());
        ArrayList<String> smallCpy = (ArrayList<String>)juiceSmaller.clone();
        ArrayList<String> bigCpy = (ArrayList<String>)juiceBigger.clone();
        int initSize = bigCpy.size();
        if(bigCpy.removeAll(smallCpy) && initSize - smallCpy.size() == bigCpy.size())
            return 1;
        return 0;
    }

    public static Stack<Juice> getStack(ArrayList<Juice> juices){
        Stack<Juice> result = new Stack<Juice>();
        while(juices.size() > 0){
            result.add(juices.get(0));
            juices.remove(0);
            for (int i = 1; i < juices.size(); i++) {
                Juice matcher = result.peek();
                if (compare(juices.get(i), matcher) == 1) {
                    result.add(juices.get(i));
                    juices.remove(i);
                }
            }

        }
        for (Juice x : juices)
            result.add(x);
        return result;

    }
}
