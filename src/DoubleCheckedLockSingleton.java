public class DoubleCheckedLockSingleton {
    private static volatile DoubleCheckedLockSingleton INSTANCE;

    private  DoubleCheckedLockSingleton(){

    }

    public static DoubleCheckedLockSingleton getInstance(){
        if(INSTANCE==null){
            synchronized (DoubleCheckedLockSingleton.class) {
                if(INSTANCE==null){
                    INSTANCE = new DoubleCheckedLockSingleton();
                }
            }
        }
        return INSTANCE;
    }
}

//The volatile keyword is essential here.
//
//It ensures that when one thread creates the object,
//other threads correctly see the fully initialized object.
