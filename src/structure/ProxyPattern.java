package structure;

/**
 * 一个类代表另一个类的功能。
 * 创建具有现有对象的对象，以便向外界提供功能接口
 */
public class ProxyPattern {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);

        proxy.buy();
    }
}

interface Subject {
    void buy();
}

class Proxy implements Subject {
    protected RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("办理购买前的手续");
        realSubject.buy(); // 付钱
        System.out.println("办理购买后的手续");
    }
}

class RealSubject implements Subject {

    @Override
    public void buy() {
        System.out.println("付钱");
    }
}