package spring.aop;

/**
 * Created by jasyu on 2019/12/31.
 **/
public class TargeUserImpl implements IUser {
    public void addUser(String name) {
        System.out.println("TargeUserImpl: add a user." + name);
    }
}
