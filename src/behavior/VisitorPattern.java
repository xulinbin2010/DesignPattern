package behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 */
public class VisitorPattern {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new ConcreteElementA());
        ConcreteElementB concreteElementB = new ConcreteElementB();
        objectStructure.attach(concreteElementB);
//        objectStructure.detach(concreteElementB);
        Visitor visitor = new ConcreteVisitor();
        objectStructure.accept(visitor);
    }
}

// 访问器接口，定义了对不同元素类型的访问操作
interface Visitor {
    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}

// 具体访问器实现，针对不同的元素类型实现不同的访问逻辑
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者访问：" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者访问：" + element.operationB());
    }
}

// 元素接口，定义了接受访问器的方法
interface Element {
    void accept(Visitor visitor);
}

// 具体元素A，实现接受访问器的方法
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "操作A";
    }
}

// 具体元素B，实现接受访问器的方法
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "操作B";
    }
}

// 对象结构，可以包含多个不同类型的元素
class ObjectStructure {

    //所有对象元素的结合
    private final List<Element> elements = new ArrayList<>();

    public void attach(Element element) {
        elements.add(element);
    }

    public void detach(Element element) {
        elements.remove(element);
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}