package create;

public class FactoryMethod {
    // 客户端代码
    public static void main(String[] args) {
        // 使用工厂类创建具体产品对象
        ProductOne productOneA = Factory.createProduct("A");
        productOneA.operation(); // Output: ConcreteProductA operation

        ProductOne productOneB = Factory.createProduct("B");
        productOneB.operation(); // Output: ConcreteProductB operation
    }
}

// 定义产品接口
interface ProductOne {
    void operation();
}

// 具体产品类 A
class ConcreteProductA implements ProductOne {
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}

// 具体产品类 B
class ConcreteProductB implements ProductOne {
    public void operation() {
        System.out.println("ConcreteProductB operation");
    }
}

// 工厂类
class Factory {
    // 创建产品方法，根据传入的参数创建对应的产品对象
    public static ProductOne createProduct(String productType) {
        if (productType.equals("A")) {
            return new ConcreteProductA();
        } else if (productType.equals("B")) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Unknown product type");
        }
    }
}




