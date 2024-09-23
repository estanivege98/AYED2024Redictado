package TP2.Cola;
import java.util.*;
public class Queue <T> extends Sequence{
    protected List <T> data;

    public Queue(){
        data = new ArrayList<>();
    }
    public void enqueue(T dato){
        data.add(dato);
    }
    public T dequeue(){
        T aux = this.data.get(0);
        data.remove(0);
        return aux;
    }
    public boolean isEmpty(){
        return (data.isEmpty());
    }
    public T head(){
        return (data.get(0));
    }
    public int size(){
        return (data.size());
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i));
            if (i < data.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
