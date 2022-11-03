import java.util.ArrayList;
import java.util.List;

/**
 * 设计循环队列
 * @since v0.0.0
 * @since 2022/11/3
 */
public class Solution622 {

    int size;
    List<Integer> arr;

    public Solution622(int k) {
        size = k;
        arr = new ArrayList<>();
    }

    public boolean enQueue(int value) {
        if (arr.size() < size) {
            arr.add(value);
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (arr.isEmpty()) return false;
        arr.remove(0);
        return true;
    }

    public int Front() {
        if (arr.isEmpty()) return -1;
        return arr.get(0);
    }

    public int Rear() {
        if (arr.isEmpty()) return -1;
        return arr.get(arr.size() - 1);
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public boolean isFull() {
        return arr.size() == size;
    }

}

