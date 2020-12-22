package spring.aop;

/**
 * Created by jasyu on 2019/12/31.
 **/
public class ProxyUserImpl implements IUser {
    private IUser iUser;

    public ProxyUserImpl(IUser iUser) {
        this.iUser = iUser;
    }

    public void addUser(String name) {
        iUser.addUser(name);
        System.out.println("ProxyUserImpl: do a operation.");
    }
}
