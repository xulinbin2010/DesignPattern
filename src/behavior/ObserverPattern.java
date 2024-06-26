package behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式是一种行为设计模式， 允许你定义一种订阅机制， 可在对象事件发生时通知多个 “观察” 该对象的其他对象。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject("目标1");

        Observer observerA = new ConcreteObserver("张三", subject);
        Observer observerB = new ConcreteObserver("李四", subject);
        Observer observerC = new ConcreteObserver("王五", subject);

        subject.setState("更新了");
        System.out.println("=============处理中=========================");
        subject.detach(observerC);
        subject.setState("停更了");
    }
}

interface Subject { // 目标
    void Attach(Observer observer); // 添加观察者

    void detach(Observer observer); // 删除观察者

    void setState(String state); // 设置状态（改变状态）

    String getState(); // 获取状态
}

class ConcreteSubject implements Subject {
    private final String name;
    private String state;

    private final List<Observer> observerList;

    public ConcreteSubject(String name) {
        state = "未更新";
        this.name = name;
        observerList = new ArrayList<>();
    }

    public void setState(String state) {
        this.state = state;

        System.out.println(name + "的状态发生变化，变化后的状态为：" + state);
        notifyIt();
    }

    public String getState() {
        return state;
    }

    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    private void notifyIt() {
        // for (遍历对象类型 对象名 : 遍历对象)
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}

interface Observer { // 观察者接口
    void update(); // 收到通知 更新观察者的状态
}

class ConcreteObserver implements Observer {
    private final String name;
    private String state;
    private final Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;

        this.subject = subject;
        subject.Attach(this);

        state = subject.getState();
    }

    @Override
    public void update() {
        System.out.println(name + "收到通知");
        state = subject.getState(); // 让当前观察者的状态 和 改变了状态之后的目标的状态保持一致
        System.out.println(name + "改变后的状态为：" + state);
    }
}

