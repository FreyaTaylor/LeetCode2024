package src._JavaBasic.DynamicProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象方法调用之前可以添加一些逻辑
        System.out.println("Before the service call.");

        // 调用目标对象的方法
        Object result = method.invoke(target, args);

        // 在目标对象方法调用之后可以添加一些逻辑
        System.out.println("After the service call.");

        return result;
    }
}
