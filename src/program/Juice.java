package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by demeng on 15.02.15.
 */
public class Juice {
    private List<String> components;
    private int componentsNumber;

    public Juice(String name) {
        String[] components = name.split(" ");
        this.components = new ArrayList<String>(Arrays.asList(components));
        this.componentsNumber = this.components.size();
    }

    public List<String> getComponents() {
        return components;
    }

    public int getComponentsNumber() {
        return componentsNumber;
    }


}
