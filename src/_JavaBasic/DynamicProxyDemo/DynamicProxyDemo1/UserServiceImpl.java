package src._JavaBasic.DynamicProxyDemo.DynamicProxyDemo1;

public class UserServiceImpl {
    public void addUser(String username) {
        System.out.println("Add user: " + username);
    }

    public void deleteUser(String username) {
        System.out.println("Delete user: " + username);
    }
}