import java.util.NoSuchElementException;
import java.util.Objects;

record Pair(String str, Pair rest){
    static int length(Pair p){
        return switch(p){
            case null -> 0;
            case Pair(String s, Pair r) -> {
                yield 1 + length(r);
            }
        };
    }
    static Pair reverse(Pair lst) {
        Pair result = null;
        while (lst != null) {
            result = new Pair(lst.str(), result);
            lst = lst.rest();
        }
        return result;
    }
}
public class LLStack {
    Pair elts;
    LLStack(Pair elts){
        this.elts = elts;
    }
    public boolean equals(Object other){
        if (this == other){ return true;}
        else if (!(other instanceof LLStack)) {return false;}
        LLStack that = (LLStack) other;
        return Objects.equals(this.elts, that.elts);
    }
    //takes no args and returns empty Stack
    static LLStack llempty_stack(){
        return new LLStack(null);
    }
    //add element to stack
    void llpush(String elt){
        this.elts = new Pair(elt,this.elts);
    }
    //remove elt from top and return it
    String llpop(){
        switch(this.elts){
            case null:
                throw new NoSuchElementException("Invalid element");
            case Pair(String f, Pair r):
                this.elts = r;
                return f;
        }
    }
    //just sends elt from top
    String llpeep(){
        switch(this.elts){
            case null:
                throw new NoSuchElementException("Invalid element");
            case Pair(String f, Pair r):
                return f;
        }
    }
    int llsize(){
        /*switch(this.elts){
            case null: return 0;
            case Pair(String f, Pair r):
                return 1 + new LLStack(r).llsize();
        }*/
        return Pair.length(this.elts);
    }
    boolean llis_empty(){
        switch(this.elts){
            case null: return true;
            case Pair(String f, Pair r):
                return false;
        }
    }
}