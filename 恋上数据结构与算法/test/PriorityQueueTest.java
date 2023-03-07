package Nine_集合.com.BXuan.set;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author {作者名字}
 * @Date: 2022/11/21/ 20:03
 * @description
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(4);
        list.add(8);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(list);
        priorityQueue.stream().sorted().forEach(System.out::println);
    }
}
