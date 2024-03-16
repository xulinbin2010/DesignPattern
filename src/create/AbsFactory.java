package create;

public class AbsFactory {

    // 定义抽象产品接口A
    interface ProductA {
        void operationA();
    }

    // 具体产品类A1
    static class ConcreteProductA1 implements ProductA {
        public void operationA() {
            System.out.println("ConcreteProductA1 operation");
        }
    }

    // 具体产品类A2
    static class ConcreteProductA2 implements ProductA {
        public void operationA() {
            System.out.println("ConcreteProductA2 operation");
        }
    }

    // 定义抽象产品接口B
    interface ProductB {
        void operationB();
    }

    // 具体产品类B1
    static class ConcreteProductB1 implements ProductB {
        public void operationB() {
            System.out.println("ConcreteProductB1 operation");
        }
    }

    // 具体产品类B2
    static class ConcreteProductB2 implements ProductB {
        public void operationB() {
            System.out.println("ConcreteProductB2 operation");
        }
    }

    // 抽象工厂接口
    interface AbstractFactory {
        ProductA createProductA();

        ProductB createProductB();
    }

    // 具体工厂类1，用于创建产品族1
    static class ConcreteFactory1 implements AbstractFactory {
        public ProductA createProductA() {
            return new ConcreteProductA1();
        }

        public ProductB createProductB() {
            return new ConcreteProductB1();
        }
    }

    // 具体工厂类2，用于创建产品族2
    static class ConcreteFactory2 implements AbstractFactory {
        public ProductA createProductA() {
            return new ConcreteProductA2();
        }

        public ProductB createProductB() {
            return new ConcreteProductB2();
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建工厂1并使用它创建产品族1
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        productA1.operationA(); // Output: ConcreteProductA1 operation
        ProductB productB1 = factory1.createProductB();
        productB1.operationB(); // Output: ConcreteProductB1 operation

        // 创建工厂2并使用它创建产品族2
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        productA2.operationA(); // Output: ConcreteProductA2 operation
        ProductB productB2 = factory2.createProductB();
        productB2.operationB(); // Output: ConcreteProductB2 operation
    }

}
