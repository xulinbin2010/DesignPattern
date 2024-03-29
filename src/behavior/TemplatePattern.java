package behavior;

/**
 * 在模板模式（Template Pattern）中，一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。
 * 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 在造房子的时候，地基、走线、水管都一样，只有在建筑的后期才有加壁橱加栅栏等差异
 */

public class TemplatePattern {

    public static void main(String[] args) {
        Student student = new Student();
        student.templateMethods();
        Teacher teacher = new Teacher();
        teacher.templateMethods();
    }
}


abstract class Person {
    public Person() {

    }

    public void templateMethods() {
        System.out.println("去教室");
        operative1();
        System.out.println("离开教室 ");
        operative2();
    }

    abstract void operative1();

    abstract void operative2();
}

class Teacher extends Person {
    public Teacher() {
        System.out.println("我是老师--------");
    }

    @Override
    public void operative1() {
        System.out.println("老师上课");
    }

    @Override
    public void operative2() {
        System.out.println("老师批改作业");
    }
}

class Student extends Person {

    public Student() {
        System.out.println("我是学生--------");
    }

    @Override
    public void operative1() {
        System.out.println("学生听课");
    }

    @Override
    public void operative2() {
        System.out.println("学生写作业");
    }
}
