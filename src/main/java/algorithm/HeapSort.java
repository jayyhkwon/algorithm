package algorithm;

public class HeapSort {

    // 최대힙의 0번째 값(최대값)을 가장 뒤로 보내 정렬한다.
    public static void heapSort(Heap heap){
        buildMaxHeap(heap);
        int tmp = Integer.MIN_VALUE;
        for(int i = heap.length()-1; i>=0; i--){
            swap(heap,i,0);
            heap.decrementSize();
            maxHeapify(heap,0);
        }
    }

    private static void buildMaxHeap(Heap heap){
        for(int i = heap.length()/2-1; i>=0; i--)
            maxHeapify(heap,i);
    }

    private static void maxHeapify(Heap heap, int idx){
        int leftIndex = getLeftIndex(idx);
        int rightIndex = getRightIndex(idx);
        int size = heap.size();
        int largest = -1;

        // 왼쪽 노드와 비교
        if(leftIndex < size && heap.get(leftIndex) > heap.get(idx))
            largest = leftIndex;
        else
            largest = idx;
        // 오른쪽 노드와 비교
        if(rightIndex < size && heap.get(rightIndex) > heap.get(largest))
            largest = rightIndex;
        // 부모 노드보다 자식노드가 큰 경우 교환
        if(largest != idx){
            swap(heap, idx, largest);
            //재귀호출
            maxHeapify(heap,largest);
        }
    }

    private static void swap(Heap heap, int to, int from) {
        int tmp = heap.get(to);
        heap.set(to, heap.get(from));
        heap.set(from, tmp);
    }

    private static int getLeftIndex(int idx){
        return 2*idx+1;
    }

    private static int getRightIndex(int idx){
        return 2*idx+2;
    }

    public static class Heap {
        int[] heap;
        int size;

        public Heap(int[] src){
            heap = src;
            size = heap.length;
        }

        public int size(){
            return size;
        }

        public int length(){
            return heap.length;
        }

        public void decrementSize(){
            size--;
        }

        public int get(int idx){
            return heap[idx];
        }

        public int[] getHeap(){
            return heap;
        }

        public void set(int idx, int value){
            heap[idx] = value;
        }
    }

}
