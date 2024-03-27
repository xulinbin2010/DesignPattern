package behavior;

/**
 * 模版方法
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
