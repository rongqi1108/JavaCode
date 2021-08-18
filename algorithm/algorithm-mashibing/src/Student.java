import java.util.ArrayList;

public class Student {
    int id;
    String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 证明选择排序的不稳定性
 */
class Test {
    public static void main(String[] args) {
        Student stu1 = new Student(5, "张三");
        Student stu2 = new Student(3, "李四");
        Student stu3 = new Student(5, "王五");
        Student stu4 = new Student(2, "赵六");
        Student stu5 = new Student(1, "朱七");
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("排序前：");
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        for(Student s : students){
            System.out.print(s.id+", "+s.name);
            System.out.println();
        }
        for (int i = 0; i < students.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < students.size(); j++) {
                min = students.get(j).id < students.get(min).id ? j : min;
            }
            Student temp = students.get(i);
            students.set(i,students.get(min));
            students.set(min,temp);
        }
        System.out.println("选择排序后：");
        for(Student s : students){
            System.out.print(s.id+", "+s.name);
            System.out.println();
        }

    }
}
