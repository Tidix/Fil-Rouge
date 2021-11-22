package solvers;

import constraints.Activity;
import constraints.PrecedenceConstraint;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TopologicalSorter {

    public ArrayList<Activity> acts;

    public TopologicalSorter(ArrayList<Activity> a){
        this.acts = a;
    }

    public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints){
        ArrayList<Activity> toReturn = new ArrayList<>();
        for(Activity a : activities){
            if(!toReturn.contains(a)){
                toReturn = addActivity(a,activities,constraints,toReturn);
            }
        }
        if(toReturn.size()!=activities.size()){
            return null;
        }
        return toReturn;
    }

    public ArrayList<Activity> addActivity(Activity a,HashSet<Activity> activities,HashSet<PrecedenceConstraint> constraints,ArrayList<Activity> acts) {
        for(PrecedenceConstraint c : constraints){
            if(c.a2==a){
                if(!acts.contains(c.a1)){
                    acts = addActivity(c.a1,activities,constraints,acts);
                }
            }
        }
        acts.add(a);
        return acts;
    }


    public HashMap<Activity, Integer> schedule(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints){
        HashMap<Activity,Integer> toReturn = new HashMap<>();
        ArrayList<Activity> acts;
        acts = this.bruteForceSort(activities,constraints);
        int counter = 0;
        for(Activity a : acts){
            toReturn.put(a,counter);
            counter+=a.getDuree();
        }
        return toReturn;
    }








}
