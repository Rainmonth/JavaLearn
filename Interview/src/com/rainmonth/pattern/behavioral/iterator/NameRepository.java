package com.rainmonth.pattern.behavioral.iterator;

public class NameRepository implements Container {
    public String names[] = {"Ethan", "Jason", "Karen", "Ascii"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    /**
     * 迭代器实现
     */
    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}