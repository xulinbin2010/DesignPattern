package create;

import java.util.ArrayList;
import java.util.List;


/**
 * 使用多个简单的对象一步一步构建成一个复杂的对象
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.Construct(builder1);
        Product product1 = builder1.getResult();
        System.out.print("产品1");
        product1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        Product product2 = builder2.getResult();
        System.out.print("产品2");
        product2.show();
    }
}

class Director {
    public void Construct(Builder builder) {
        builder.BuildPart();
    }
}

abstract class Builder {
    public abstract void BuildPart();

    public abstract Product getResult();
}

class Builder1 extends Builder {
    Product product = new Product();

    @Override
    public void BuildPart() {
        product.Add("A");
        product.Add("B");
        product.Add("C");
        product.Add("D");
        product.Add("E");
        product.Add("F");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Builder2 extends Builder {
    Product product = new Product();

    @Override
    public void BuildPart() {
        product.Add("A");
        product.Add("B");
        product.Add("C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Product {
    List<String> parts = new ArrayList<>();

    public void Add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.print("组成：");
        for (String s : parts)
            System.out.print(s + " ");

        System.out.print("\n");
    }
}
