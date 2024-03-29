package behavior;

/**
 * 创建表示各种状态的对象和一个行为随着状态对象改变而改变的context对象。
 * 允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(); // count：3

        System.out.println(context.getState().stateName());

        context.Request(); // 购买一个饮料 count = 2
        context.Request(); // 购买一个饮料 count = 1
        context.Request(); // 购买一个饮料 count = 0

        System.out.println(context.getState().stateName());

        context.Request(); // 无货 等待补货 补货成功 count = 5

        System.out.println(context.getState().stateName());

        context.Request(); // 购买一个饮料 count = 4

    }
}

class Context { // 贩卖机
    private int count;

    private State state;

    public Context() {
        count = 3;
        state = new StateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Request() { // 购买一个饮料
        state.Handle(this);
    }

}

interface State {
    void Handle(Context context);

    String stateName();
}

class StateA implements State { // 有货


    @Override
    public String stateName() {
        return "正常状态";
    }

    @Override
    public void Handle(Context context) {
        int count = context.getCount();

        if (count >= 1) {
            System.out.print("购买成功！");
            context.setCount(count - 1);
            System.out.println("此时count = "+context.getCount());

            if (context.getCount() == 0) {
                context.setState(new StateB());
            }
        } else {
            System.out.println("购买失败！");
        }
    }

}

class StateB implements State { // 无货

    @Override
    public String stateName() {
        return "空状态";
    }

    @Override
    public void Handle(Context context) {
        int count = context.getCount();

        if (count == 0) {
            System.out.print("购买失败！等待补货");
            System.out.println(" 此时count="+context.getCount());
            context.setCount(5);
            System.out.print("补货成功，请重新购买");
            System.out.println(" 此时count="+context.getCount());
            context.setState(new StateA());
        }
    }
}