import constraints.Activity;
import constraints.PrecedenceConstraint;
import solvers.TopologicalSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String args[]){//TODO : retourne vraiment nul? insh oui normalement mais pas sûr
        Activity a1 = new Activity("Se lever",2);
        Activity a2 = new Activity("S'habiller",1);
        Activity a3 = new Activity("déjeuner",10);
        Activity a4 = new Activity("Brosser les dents",3);
        Activity a5 = new Activity("Partir alafac",2);
        PrecedenceConstraint pc1 = new PrecedenceConstraint(a1,a2);
        PrecedenceConstraint pc2 = new PrecedenceConstraint(a1,a3);
        PrecedenceConstraint pc3 = new PrecedenceConstraint(a1,a4);
        PrecedenceConstraint pc4 = new PrecedenceConstraint(a1,a5);
        PrecedenceConstraint pc5 = new PrecedenceConstraint(a2,a5);
        PrecedenceConstraint pc6 = new PrecedenceConstraint(a3,a4);
        PrecedenceConstraint pc7 = new PrecedenceConstraint(a3,a5);
        PrecedenceConstraint pc8 = new PrecedenceConstraint(a4,a5);
        HashSet<Activity> activities = new HashSet<Activity>();
        HashSet<PrecedenceConstraint> constraints = new HashSet<PrecedenceConstraint>();
        activities.add(a3);
        activities.add(a5);
        activities.add(a2);
        activities.add(a1);
        activities.add(a4);
        constraints.add(pc5);
        constraints.add(pc1);
        constraints.add(pc3);
        constraints.add(pc2);
        constraints.add(pc8);
        constraints.add(pc4);
        constraints.add(pc7);
        constraints.add(pc6);
        ArrayList<Activity> activityList = new ArrayList<>();
        TopologicalSorter tps = new TopologicalSorter(activityList);
        HashMap<Activity, Integer> acts;
        acts = tps.schedule(activities,constraints);
        activityList = tps.bruteForceSort(activities,constraints);
        int counter = 0;
        int counter2 = 0;
        while(counter2 != acts.size())
        for(Activity a : acts.keySet()){
            if(acts.get(a)==counter){
                System.out.println(a.getDescription() + " " + a.getDuree() + " " + counter);
                counter +=a.getDuree();
                counter2+=1;
            }
        }
        for(Activity a : activityList){
            System.out.println(a.getDescription());
        }

    }

}
