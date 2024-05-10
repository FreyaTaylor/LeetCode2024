package src._JavaBasic.DynamicProxyDemo;

import java.lang.reflect.Proxy;

public class JDKDynamicProxyExample {
    public static void main(String[] args) {
        // 创建服务的实际对象
        Service service = new RealService();

        // 创建动态代理的调用处理器，并传入实际的服务对象
        MyInvocationHandler handler = new MyInvocationHandler(service);

        // 通过Proxy类和调用处理器创建代理对象
        Service proxyService = (Service) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                new Class[]{Service.class}, // 指定代理类实现的接口
                handler);

        // 使用代理对象调用方法
        proxyService.serve();
    }
}