package Program;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by demeng on 15.02.15.
 */
public class Program {
    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        final ArrayList<Juice> juices = new ArrayList<Juice>();
        while (sc.hasNext()) {
            Juice read = new Juice(sc.nextLine());
            juices.add(read);
        }

        Collections.sort(juices, new Comparator<Juice>() {
            @Override
            public int compare(Juice o1, Juice o2) {
                return o1.getComponentsNumber() - o2.getComponentsNumber();
            }
        });
        ArrayList<Juice> juicesTmp = (ArrayList<Juice>) juices.clone();
        Stack<Juice> juiceStack = Methods.getStack(juices);

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
        ArrayList<String> components = Methods.getComponents(juicesTmp);
        File f1 = new File("juice1.out");
        PrintStream ps1 = new PrintStream(f1);
        for (String x : components) {
            ps1.println(x);
            ps1.flush();
        }

        Collections.sort(components);
        File f2 = new File("juice2.out");
        PrintStream ps2 = new PrintStream(f2);
        for (String x : components) {
            ps2.println(x);
            ps2.flush();
        }

        File f3 = new File("juice3.out");
        PrintStream ps3 = new PrintStream(f3);
        ps3.println("Number of cleanings: " + cleanings);
        ps3.flush();
    }
}
