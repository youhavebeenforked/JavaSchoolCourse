package src.ru.sberbank.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class ShowcaseProxy {
    private static String userName;
    private static Service proxy = getProxy();

    public static void main(String[] args) {
        System.out.println("Enter username: ");
        Scanner in = new Scanner(System.in);
        userName = in.nextLine();
        try {
            System.out.println(proxy.getImportantData());
        } catch (RuntimeException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static Service getProxy() {
        return (Service) Proxy.newProxyInstance(ShowcaseProxy.class.getClassLoader(),
                new Class[]{Service.class}, new DynamicInvocationHandler(new ServiceImpl()));

    }

    private static class DynamicInvocationHandler implements InvocationHandler {
        private final Object wrappedService;

        private DynamicInvocationHandler(Object wrappedService) {
            this.wrappedService = wrappedService;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("Invoked method: " + method.getName());
            if ("admin".equalsIgnoreCase(userName)) {
                return method.invoke(wrappedService, args);
            } else {
                throw new RuntimeException("Access denied!");
            }
        }
    }
}
