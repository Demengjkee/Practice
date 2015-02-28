package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by demeng on 15.02.15.
 */
public class Juice {
    private List<String> components;


    public Juice(String name) {
        String[] components = name.split(" ");
        this.components = (Arrays.asList(components));

    }

    public List<String> getComponents() {
        return components;
    }

    public int getComponentsNumber() {
        return this.components.size();
    }


}
