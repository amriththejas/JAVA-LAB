import java.util.Arrays;

// Generic class for a dynamic queue
class DynamicQueue<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;

    // Constructor
    public DynamicQueue(int initialCapacity) {
        queue = new Object[initialCapacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(T element) {
        if (size == queue.length) {
            resizeQueue();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    // Dequeue operation
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = (T) queue[front];
        front = (front + 1) % queue.length;
        size--;
        return element;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }

    // Resize the queue when capacity is full
    private void resizeQueue() {
        int newCapacity = queue.length * 2;
        Object[] newQueue = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }

    // Display the queue elements
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % queue.length] + " ");
            }
            System.out.println();
        }
    }
}

// Main class to test the DynamicQueue
public class DynamicQueueDemo {
    public static void main(String[] args) {
        DynamicQueue<Integer> intQueue = new DynamicQueue<>(3);

        // Enqueue elements
        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);
        intQueue.displayQueue();

        // Enqueue more elements (resize will happen)
        intQueue.enqueue(40);
        intQueue.enqueue(50);
        intQueue.displayQueue();

        // Dequeue elements
        System.out.println("Dequeued: " + intQueue.dequeue());
        System.out.println("Dequeued: " + intQueue.dequeue());
        intQueue.displayQueue();

        // Enqueue again
        intQueue.enqueue(60);
        intQueue.displayQueue();
    }
}







Queue: 10 20 30 
Queue: 10 20 30 40 50 
Dequeued: 10
Dequeued: 20
Queue: 30 40 50 
Queue: 30 40 50 60