package program;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");
        ArrayList<Juice> juices = Methods.readJuices(f);
        Collections.sort(juices, new Comparator<Juice>() {
            @Override
            public int compare(Juice o1, Juice o2) {
                return o1.getComponentsNumber() - o2.getComponentsNumber();
            }
        });
        ArrayList<Juice> juicesTmp = (ArrayList<Juice>) juices.clone();
        Stack<Juice> juiceStack = Methods.getStack(juices);

        int cleanings = Methods.countCleanings(juiceStack);

        ArrayList<String> components = Methods.getCommonComponents(juicesTmp);

        File f1 = new File("juice1.out");
        Methods.writeComponents(components, f1);
        Collections.sort(components);
        File f2 = new File("juice2.out");
        Methods.writeComponents(components,f2);
        File f3 = new File("juice3.out");
        PrintStream ps3 = new PrintStream(f3);
        ps3.println("Number of cleanings: " + cleanings);
        ps3.flush();
    }
}
