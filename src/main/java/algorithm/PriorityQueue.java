package algorithm;

import java.util.Arrays;

/**
 * have a higher priority if value is bigger
 */
public class PriorityQueue {

    private Heap heap;

    public PriorityQueue(int[] src){
        heap = new Heap(src);
    }

    public int size() {
        return heap.size();
    }

    public int extractMax() throws Exception {
        if(heap.size() < 1)
            throw new Exception("heap underflow");

        int max = heap.get(0);
        heap.set(0,heap.get(getLastIndex()));
        heap.decrementSize();
        maxHeapify(0);
        return max;
    }

    public int getMaximum() throws Exception {
        return heap.get(0);
    }

    private int getLastIndex() {
        return heap.size()-1;
    }

    public void increaseKey(int idx, int key) throws Exception {
        if(idx >= heap.size())
            throw new IndexOutOfBoundsException();

        if(key < heap.get(idx))
            throw new Exception("new key is smaller than exist value");

        heap.set(idx,key);
        while(idx > 0 && heap.get(heap.getParentIndex(idx)) < heap.get(idx)){
            swap(idx, heap.getParentIndex(idx));
            idx = heap.getParentIndex(idx);
        }
    }

    public void insert(int key) throws Exception {
        heap.checkCapacity();
        heap.incrementSize();
        increaseKey(heap.size()-1, key);
    }

    private void maxHeapify(int idx) {

        if(idx < 0 || idx >= heap.size)
            throw new IndexOutOfBoundsException();

        int leftIndex = heap.getLeftIndex(idx);
        int rightIndex = heap.getRightIndex(idx);
        int size = heap.size();
        int largest = -1;
        int tmp = Integer.MIN_VALUE;

        // compare with leftNode
        if(leftIndex < size && heap.get(leftIndex) > heap.get(idx))
            largest = leftIndex;
        else
            largest = idx;
        // compare with rightNode
        if(rightIndex < size && heap.get(rightIndex) > heap.get(largest))
            largest = rightIndex;
        // swap if parentNode is bigger than child.
        if(largest != idx){
            swap(idx, largest);
            //reculsive call
            maxHeapify(largest);
        }
    }

    private void swap(int from, int to) {
        int tmp;
        tmp = heap.get(from);
        heap.set(from,heap.get(to));
        heap.set(to,tmp);
    }

    public String toString(){
         return Arrays.toString(heap.array);
    }

    public class Heap {
        int[] array = {};
        int size;

        public Heap(int[] src){
            array = src;
            size = array.length;
        }

        public Heap(){
            array = new int[10];
            size = array.length;
        }

        public int getLeftIndex(int idx){
            return 2*idx+1;
        }

        public int getRightIndex(int idx){
            return 2*idx+2;
        }

        public int getParentIndex(int idx){return idx/2;}

        // heap's size
        public int size(){
            return size;
        }

        // array's size
        public int length(){
            return array.length;
        }

        public void incrementSize(){ size++; }

        public void decrementSize(){
            size--;
        }

        public int get(int idx) {
            return array[idx];
        }

        // if heap's size is bigger than array's length, grow array's size;
        private void checkCapacity() {
            int oldCapacity = length();
            if(size >= oldCapacity){
                int newCapacity = oldCapacity + 10;
                array = Arrays.copyOf(array, newCapacity);
            }
        }

        public int[] getHeap(){
            return array;
        }

        public boolean isValid(int idx){
            return size-1 >= idx ? true : false;
        }

        public void set(int idx, int value) {
            if(isValid(idx)){
                array[idx] = value;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
