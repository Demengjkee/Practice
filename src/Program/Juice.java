package Program;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by demeng on 15.02.15.
 */
public class Juice {
    private ArrayList<String> components;
    private int componentsNumber;

    public Juice(ArrayList<String> components,int componentsNumber){
        this.components = components;
        this.componentsNumber = componentsNumber;
    }
    public Juice(String name){
        String[] components = name.split(" ");
        this.components = new ArrayList<String>(Arrays.asList(components));
        this.componentsNumber = this.components.size();
    }

    public ArrayList<String> getComponents(){
        return components;
    }
    public int getComponentsNumber(){
        return componentsNumber;
    }


}
