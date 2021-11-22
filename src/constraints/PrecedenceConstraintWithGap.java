package constraints;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
    int dureeMin;
    int dureeMax;
    public PrecedenceConstraintWithGap(Activity a1, Activity a2, int dureeMin, int dureeMax) {
        super(a1, a2);
        this.dureeMin = dureeMin;
        this.dureeMax = dureeMax;
    }

    @Override
    public boolean isSatisfied(int d1, int d2) {
        if(this.a1.duree+d1>d2){
            return false;
        }
        if(d2 > this.a1.duree+dureeMax || d2 < this.a1.duree+dureeMin){
            return false;
        }
        return true;
    }


}
