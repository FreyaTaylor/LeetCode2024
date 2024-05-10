package src._JavaBasic.DynamicProxyDemo.DynamicProxyDemo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxy {
    private Object target; // 被代理的目标对象

    // 绑定目标对象，并返回代理对象
    public Object bind(Object target) {
        this.target = target;
        // 创建代理对象，并绑定代理处理器
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (InvocationHandler) this);
    }

    // 代理处理器的 invoke 方法，在代理对象调用方法时会被调用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method invocation");
        Object result = method.invoke(target, args); // 调用目标对象的方法
        System.out.println("After method invocation");
        return result;
    }
}

