import java.util.*;

public class ArrayList implements List {
    private int size;
    private Object[] arr;
    private int current;

    public ArrayList(){
        arr = new Object[10];
        size = 10;
        current = 0;
    }

    @Override
    public void add(Object obj) {
        if(current >= size){
            Object[] temp = new Object[size*2];
            for(int i = 0; i < current; i++){
                temp[i] = arr[i];
            }
            arr = temp;
            size *= 2;
        }
        arr[current++] = obj;
    }

    @Override
    public void add(int pos, Object obj) {
        if(current >= size){
            Object[] temp = new Object[size*2];
            for(int i = 0; i < current; i++){
                temp[i] = arr[i];
            }
            arr = temp;
            size *= 2;
        }

        for(int i = current; i > pos; i--){
            arr[i] = arr[i-1];
        }
        arr[pos] = obj;
        current++;
    }

    @Override
    public Object get(int pos) {
        if(pos < 0 || pos >= current){
            return 0;
        }
        return arr[pos];
    }

    @Override
    public Object remove(int pos) {
        if(pos < 0 || pos >= current){
            System.out.println("The index does not exist in the ArrayList.");
            return 0;
        }

        for(int i = pos + 1; i < current; i++){
            arr[i-1] = arr[i];
        }
        current--;
        return arr[pos];


    }

    @Override
    public int size() {
        return current;
    }
}
