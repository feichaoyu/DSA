package 分类刷题.队列;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 排序系统，当有人退出时，能看到自己的变化
 */
public class SortSystem {
    public static void main(String[] args) {
        User user1 = new User(1, "user1");
        User user2 = new User(2, "user2");
        User user3 = new User(3, "user3");
        User user4 = new User(4, "user4");
        User user5 = new User(5, "user5");

        MyQueue queue = new MyQueue();
        queue.enqueue(user1);
        queue.enqueue(user2);
        queue.enqueue(user3);
        queue.enqueue(user4);
        queue.enqueue(user5);

        // 队首元素出队
        queue.dequeue();
        // 指定元素出队
        queue.dequeue(user3);
        queue.print();
    }
}

class User {

    private int id;
    private String name;
    private int seq;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.seq = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seq);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seq=" + seq +
                '}';
    }
}

class MyQueue {

    private Queue<User> queue = new LinkedList<>();

    public void enqueue(User user) {
        user.setSeq(queue.size() + 1);
        queue.add(user);
    }

    public void dequeue() {
        queue.poll();
        updateSeq();
    }

    public void dequeue(User user) {
        queue.remove(user);
        updateSeq();
    }

    /**
     * 出队后更新队列中每个用户的序列
     */
    private void updateSeq() {
        int i = 1;
        for (User user : queue) {
            user.setSeq(i++);
        }
    }

    public void print() {
        for (User user : queue) {
            System.out.println(user);
        }
    }
}
