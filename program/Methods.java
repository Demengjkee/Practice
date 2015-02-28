package program;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


public class Methods {
    public static int compareJuices(Juice o1, Juice o2) {
        List<String> juiceBigger = (o1.getComponents().size() >= o2.getComponents().size()) ?
                (o1.getComponents()) : (o2.getComponents());
        List<String> juiceSmaller = (o1.getComponents().size() < o2.getComponents().size()) ?
                (o1.getComponents()) : (o2.getComponents());
        List<String> smallCopy = new ArrayList<String>(juiceSmaller);
        List<String> bigCopy = new ArrayList<String>(juiceBigger);
        int initialSize = bigCopy.size();
        if (bigCopy.removeAll(smallCopy) && ((initialSize - smallCopy.size()) == bigCopy.size()))
            return 1;
        return 0;
    }

    public static Stack<Juice> getStack(ArrayList<Juice> juices) {
        Stack<Juice> result = new Stack<Juice>();
        while (juices.size() > 0) {
            result.add(juices.get(0));
            juices.remove(0);
            for (int i = 1; i < juices.size(); i++) {
                Juice matcher = result.peek();
                if (compareJuices(juices.get(i), matcher) == 1) {
                    result.add(juices.get(i));
                    juices.remove(i);
                }
            }

        }
        for (Juice juice : juices)
            result.add(juice);
        return result;

    }

    public static ArrayList<String> getCommonComponents(List<Juice> juices) {
        ArrayList<String> result = new ArrayList<String>();
        for (Juice x : juices) {
            for (String y : x.getComponents()) {
                if (!result.contains(y)) {
                    result.add(y);
                }

            }
        }
        return result;
    }

    public static ArrayList<Juice> readJuices(File from) throws IOException {
        Scanner sc = new Scanner(from);
        ArrayList<Juice> juices = new ArrayList<Juice>();
        while (sc.hasNext()) {
            Juice read = new Juice(sc.nextLine());
            juices.add(read);
        }
        return juices;

    }

    public static int countCleanings(Stack<Juice> juiceStack) {
        int cleanings = 1;

        Juice[] juiceSortArray = new Juice[juiceStack.size()];
        juiceStack.copyInto(juiceSortArray);
        for (int i = 0; i < juiceSortArray.length - 1; i++) {
            Juice prev = juiceSortArray[i];
            Juice next = juiceSortArray[i + 1];
            if (prev.getComponentsNumber() >= next.getComponentsNumber()) {
                cleanings++;
            }

        }
        return  cleanings;
    }

    public static void writeComponents(List<String> components,File to) throws IOException{
        PrintStream ps = new PrintStream(to);
        for (String component : components) {
            ps.println(component);
        }
        ps.flush();
    }

}
