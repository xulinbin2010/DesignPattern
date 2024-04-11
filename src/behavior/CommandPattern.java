package behavior;

/**
 * 命令模式是一种行为设计模式， 它可将请求转换为一个包含与请求相关的所有信息的独立对象。
 * 该转换让你能根据不同的请求将方法参数化、 延迟请求执行或将其放入队列中， 且能实现可撤销操作。
 */
public class CommandPattern {
    public static void main(String[] args) {
        Tv tv = new Tv(); // 接收者 对象 电视机

        Command onCommand = new OnCommand(tv); // 命令对象 开机命令
        Command offCommand = new OffCommand(tv); // 命令对象 关机命令

        Invoker invoker = new Invoker(); // 请求者
        invoker.setCommand(onCommand); // 给请求者设置 开机 命令
        invoker.call(); // 请求者去请求命令

        System.out.println("===================处理中=====================");

        invoker.setCommand(offCommand); // 给请求者设置 关机命令
        invoker.call(); // 请求者去请求命令
    }
}

class Invoker { // 请求者
    private Command command; // 命令

    public void setCommand(Command command) { // 设置请求者 的 请求的命令
        this.command = command;
    }

    public void call() { // 调用
        command.Execute();
    }
}

interface Command { // 命令接口
    void Execute(); // 执行命令
}

class OnCommand implements Command { // 开机命令
    private final Tv tv;

    public OnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAction();
    }
}

class OffCommand implements Command { // 关机命令
    private final Tv tv;

    public OffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAction();
    }
}

class Tv { // 接收者 电视机
    public void OnAction() { // 开机行为
        System.out.println("电视机开机了...");
    }

    public void OffAction() { // 关机行为
        System.out.println("电视机关机了...");
    }
}
