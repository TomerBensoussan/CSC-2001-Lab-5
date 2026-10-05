import java.util.Arrays;

public class AQueue {
    String[] list;
    int actSpot;
    AQueue(String[] list){
        this.list = list;
        this.actSpot = 0;
    }
    public boolean equals(Object other){
        if (this == other){ return true;}
        else if (!(other instanceof AQueue)) {return false;}
        AQueue that = (AQueue) other;
        return Arrays.equals(this.list, that.list);
    }
    static AQueue emptyQueue(){
        return new AQueue(null);
    }
}
