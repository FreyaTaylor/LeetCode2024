package src._JavaBasic.DynamicProxyDemo.DynamicProxyDemo1;

public class Main {
    public static void main(String[] args) {
        // 创建目标对象
        UserService userService = (UserService) new UserServiceImpl();
        // 创建代理处理器
        UserServiceProxy handler = new UserServiceProxy();
        // 绑定目标对象，并返回代理对象
        UserService proxy = (UserService) handler.bind(userService);

        // 通过代理对象调用方法
        proxy.addUser("Alice");
        proxy.deleteUser("Bob");
    }
}
