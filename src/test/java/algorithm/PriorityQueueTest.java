package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriorityQueueTest {

    private PriorityQueue priorityQueue;
    private int[] input;

    @BeforeEach
    public void setUp(){
        input = new int[]{15,13,9,5,12,8,7,4,0,6,2,1};
        priorityQueue = new PriorityQueue(input);
    }

    @Test
    public void testGetMaximum() throws Exception {
        assertEquals(priorityQueue.getMaximum(), 15);
    }

    @Test
    public void testExtractMax() throws Exception {
        int max = priorityQueue.extractMax();
        assertEquals(max, 15);
        assertEquals(priorityQueue.getMaximum(),13);
        assertEquals(priorityQueue.size(),11);
    }

    @Test
    public void testAdd() throws Exception {
        priorityQueue.insert(30);
        assertEquals(priorityQueue.getMaximum(), 30);
        priorityQueue.insert(45);
        assertEquals(priorityQueue.getMaximum(),45);
    }

}