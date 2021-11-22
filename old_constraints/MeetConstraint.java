package constraints;

public class MeetConstraint {
    Activity a1;
    Activity a2;

    public MeetConstraint(Activity a1, Activity a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public Activity getFirst(){
        return this.a1;
    }

    public Activity getSecond(){
        return this.a2;
    }
    public boolean isSatisfied(int d1, int d2){
        return (d2-d1>=this.a1.duree);
    }

}
