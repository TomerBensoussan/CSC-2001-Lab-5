public class LLQueue {
    Pair front;
    Pair back;
    LLQueue(Pair full){
        int length = Pair.length(full);
        for(int i = 0; i < length; i++){
            if (i < length/2){
                this.front = new Pair(full.str(), this.front);
            }
            else{
                this.back = new Pair(full.str(), this.back);
            }
            full = full.rest();
        }
        Pair.reverse(back);
    }
    //returns empty queue
    static LLQueue emptyQueue(){
        return new LLQueue(null);
    }
    //adds elt to end of queue
    void enqueue(String elt){
        this.back = new Pair(elt, this.back);
    }
    String dequeue(){
        if(front == null){
            if(back == null){throw new IndexOutOfBoundsException("Queue is empty");}
            else{
                this.front = Pair.reverse(this.back);
                this.back = null;
            }
        }
        String first = this.front.str();
        this.front = this.front.rest();
        return first;
    }
    String peek(){
        if(front == null){
            if(back == null){throw new IndexOutOfBoundsException("Queue is empty");}
            else{
                this.front = Pair.reverse(this.back);
                this.back = null;
            }
        }
        return this.front.str();
    }
    int size(){
        return Pair.length(this.front)+Pair.length(this.back);
    }
    boolean isEmpty(){
        return (this.front == null && this.back == null);
    }
}
