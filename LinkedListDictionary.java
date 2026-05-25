package coen352.ch4.dictionary;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListDictionary<Key , E> implements ADTDictionary<Key, E> {
    private record KVPair<Key, E>(Key key, E value) {}

    private final LinkedList<KVPair<Key, E>> list;

    public LinkedListDictionary() {
        list = new LinkedList<>();

    }

    /* clear all element in the list */
    @Override
    public void clear() {
        list.clear();
    }

    /* insert an element at the end of the list */
    @Override
    public void insert(Key k, E e) {
        list.add(new KVPair<>(k, e));

    }

    /* find the index by looping through the list
   * Sequential search
     */
    @Override
    public E find(Key k) {

        for(KVPair<Key, E> pair : list){
            if(pair.key().equals(k)){
                return pair.value();
            }
        }
        return null;
    }


    /* Remove the key.
    * we need to search for the key index through sequential search
    */
    @Override
    public E remove(Key k) {
        int index=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).key().equals(k)){
                index=i;
                break;
            }
        }
        if(index ==-1){ return null;}
        E node= list.get(index).value();
        list.remove(index);
        return node;
    }

/* randomly generate an index and remove that object at that location*/
    @Override
    public E removeAny() {
        if (list.isEmpty()) return null;
        int random= new Random().nextInt(list.size());
        E node= list.get(random).value();
        list.remove(random);
        return node;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
        public String toString() {
        StringBuilder str= new StringBuilder();


        for (KVPair<Key, E>  pair : list) {

            str.append(" < ")
                    .append(pair.key())
                    .append(" , ")
                    .append(pair.value())
                    .append(" >\n");
        }

        return str.toString();
}
}




