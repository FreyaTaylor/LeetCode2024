package src._JavaBasic.GenericsDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static src._JavaBasic.GenericsDemo.Utils.printList;

public class GenericsTest {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /**
         * 在编译之后程序会采取去泛型化的措施。也就是说Java中的泛型，只在编译阶段有效。
         * 在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
         * 也就是说，泛型信息不会进入到运行时阶段。
         */
//        List<String> stringArrayList = new ArrayList<String>();
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            System.out.println("泛型测试,类型相同");
//        }



        // 使用泛型类
        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(123);

        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello World");



        Integer[] intArray = {1, 2, 3};
        Utils.printArray(intArray);

        String[] stringArray = {"Hello", "World"};
        Utils.printArray(stringArray);


        // 使用通配符
        List<String> stringList = Arrays.asList("Apple", "Banana", "Cherry");
        printList(stringList);
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        printList(integerList);


        /**
         * 使用无界通配符的代码中，你不能对其存储的元素进行添加操作，因为不知道具体的类型信息。
         * 然而，你可以从这样的集合中取出元素，因为取出操作不依赖于具体的类型。
         */
        List<?> list = new ArrayList<>(stringList);
//        list.add("element"); // 错误：无法添加元素，因为类型未知
        Object obj = list.get(0); // 正确：可以取出元素，返回 Object 类型

        // 类型 T 或 T 的子类型
        List<? extends Number> numbers = new ArrayList<>();
// numbers.add(1); // 错误：无法添加元素，因为不知道具体的子类型
//        Number number = numbers.get(0); // 正确：可以安全地向上转型为 Number


        // 类型 T 或 T 的父类型。
        List<? super Integer> integers = new ArrayList<>();
        integers.add(10); // 正确：可以添加 Integer 的父类实例
        Object obj1 = integers.get(0); // 正确：可以取出 Object 类型的对象
// Integer i = integers.get(0); // 错误：无法向下转型为 Integer


    }
}
