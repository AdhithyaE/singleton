public class BillPughSingleton {

    private BillPughSingleton(){

    }
    private static class SingletonProvider {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonProvider.INSTANCE;
    }
}

//The JVM does not initialize SingletonProvider until it is actually used.