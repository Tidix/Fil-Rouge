package constraints;

public class PrecedenceConstraint {
    public Activity a1;
    public Activity a2;

    public PrecedenceConstraint(Activity a1, Activity a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public Activity getFirst(){
        return this.a1;
    }

    public Activity getSecond(){
        return this.a2;
    }
    public boolean isSatisfied(int d1, int d2){//45 65
        return (d1+this.a1.duree<=d2);
    }


}
