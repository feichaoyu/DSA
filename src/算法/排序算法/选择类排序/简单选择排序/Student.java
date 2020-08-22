package 算法.排序算法.选择类排序.简单选择排序;

/**
 * @author feichaoyu
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 定义Student的compareTo函数
     * 如果分数相等，则按照名字的字母序排序
     * 如果分数不等，则分数高的靠前
     *
     * @param that
     * @return
     */
    @Override
    public int compareTo(Student that) {

        if (this.score < that.score) {
            return -1;
        } else if (this.score > that.score) {
            return 1;
        } else // this.score == that.score
        {
            return this.name.compareTo(that.name);
        }
    }

    @Override
    public String toString() {
        return "Student: " + this.name + " " + Integer.toString(this.score);
    }
}

