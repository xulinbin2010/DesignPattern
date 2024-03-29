package behavior;

/**
 * 用来降低多个对象和多个类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护
 * 中介模式：关注于减少对象之间的直接依赖，通过引入中介对象来协调对象之间的交互。
 * 桥接模式：关注于将抽象与实现分离，使得抽象和实现可以独立地变化。
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.sendMessage("messageAAA");

        colleague2.sendMessage("messageBBB！");
    }
}


abstract class Colleague {
    protected Mediator mediator;
}

class Colleague1 extends Colleague {
    public Colleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("同事1收到消息：" + message);
    }
}

class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void Notify(String message) {
        System.out.println("同事2收到消息：" + message);
    }
}

abstract class Mediator {
    public abstract void sendMessage(String message, Colleague colleague);
}

class ConcreteMediator extends Mediator {
    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.Notify(message); // 让同事2收到消息
        } else {
            colleague1.Notify(message); // 让同事1收到消息
        }
    }
}