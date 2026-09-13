public class LazySingleton {
    private static LazySingleton INSTANCE;
    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(INSTANCE==null){
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}

//Created only when requested
//Saves initialization cost
//Your basic version is not thread-safe
//Can be made thread-safe with synchronization/DCL
