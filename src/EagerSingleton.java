public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton(){

    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

//The object is created when the class is loaded,
// even if the application never calls getInstance().