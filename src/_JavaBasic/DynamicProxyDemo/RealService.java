package src._JavaBasic.DynamicProxyDemo;

public class RealService implements Service {
    @Override
    public void serve() {
        System.out.println("Serving the client.");
    }
}