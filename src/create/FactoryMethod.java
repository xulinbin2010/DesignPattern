package create;

public class FactoryMethod {
    // 定义产品接口
    interface Product {
        void operation();
    }

    // 具体产品类 A
    static class ConcreteProductA implements Product {
        public void operation() {
            System.out.println("ConcreteProductA operation");
        }
    }

    // 具体产品类 B
    static class ConcreteProductB implements Product {
        public void operation() {
            System.out.println("ConcreteProductB operation");
        }
    }

    // 工厂类
    static class Factory {
        // 创建产品方法，根据传入的参数创建对应的产品对象
        public static Product createProduct(String productType) {
            if (productType.equals("A")) {
                return new ConcreteProductA();
            } else if (productType.equals("B")) {
                return new ConcreteProductB();
            } else {
                throw new IllegalArgumentException("Unknown product type");
            }
        }
    }

    // 客户端代码

    public static void main(String[] args) {
        // 使用工厂类创建具体产品对象
        Product productA = Factory.createProduct("A");
        productA.operation(); // Output: ConcreteProductA operation

        Product productB = Factory.createProduct("B");
        productB.operation(); // Output: ConcreteProductB operation
    }


}
