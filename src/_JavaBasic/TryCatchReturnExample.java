package src._JavaBasic;

public class TryCatchReturnExample {

    public static void main(String[] args) {
        int result = calculateSomething(10, 0);
        System.out.println("Result is: " + result);
    }

    public static int calculateSomething(int a, int b) {
        return doCalculation(a, b);
    }

    public static int doCalculation(int a, int b) {
        try {
            // 假设这里有可能会抛出异常的代码
            int result = a / b; // 这里故意制造一个除以0的情况
            return result;
        } catch (ArithmeticException e) {
            // 处理异常，并且返回一个默认值
            return -1; // 这里我们返回-1作为错误的标志
        }
    }
}
