import java.util.Arrays;
import java.util.NoSuchElementException;

public class AStack {
    String[] list;
    int actLength;
    AStack(String[] list){
        this.list = list;
        actLength = list.length;
    }
    AStack(String[] list, int size){
        this.list = new String[size];
        actLength = list.length;
        for (int i = 0; i < list.length; i++){
            this.list[i] = list[i];
        }
    }
    void MaybelengthenArr(){
        this.actLength++;
        if(this.list.length < this.actLength){
            String[] newArr = new String[this.actLength*2];
            for (int i = 0; i < this.list.length; i++){
                newArr[i] = this.list[i];
            }
            this.list = newArr;
        }
    }
    public boolean equals(Object other){
        if (this == other){ return true;}
        else if (!(other instanceof AStack)) {return false;}
        AStack that = (AStack) other;
        return Arrays.equals(this.list, that.list) && this.actLength == that.actLength;
    }
    //returns a new empty AStack
    static AStack aempty_stack(){
        return new AStack(new String[0]);
    }
    //adds value to start
    void apush(String elt){
        MaybelengthenArr();
        this.list[actLength-1] = elt;
    }
    String apop(){
        if(actLength < 1){
            throw new NoSuchElementException("Empty List");
        }
        String elt = this.list[actLength-1];
        this.list[actLength-1] = null;
        actLength--;
        return elt;
    }
    String apeep(){
        if(actLength < 1){
            throw new NoSuchElementException("Empty List");
        }
        return this.list[actLength-1];
    }
    int asize(){
        return actLength;
    }
    boolean ais_empty(){
        return (actLength == 0);
    }

}
