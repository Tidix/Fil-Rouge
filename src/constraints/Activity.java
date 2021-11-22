package constraints;

public class Activity {
    String description;
    int duree;

    public Activity(String s, int d){
        this.description = s;
        this.duree = d ;
    }

    public String getDescription(){
        return this.description;
    }

    public int getDuree(){
        return this.duree;
    }
}
