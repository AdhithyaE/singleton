//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws NoSuchMethodException, IOException, ClassNotFoundException, CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException {
    EagerSingleton e1 = EagerSingleton.getInstance();
    EagerSingleton e2 = EagerSingleton.getInstance();
    System.out.println(e1==e2);

    LazySingleton l1 = LazySingleton.getInstance();
    LazySingleton l2 = LazySingleton.getInstance();
    System.out.println(l1==l2);

    DoubleCheckedLockSingleton d1 = DoubleCheckedLockSingleton.getInstance();
    DoubleCheckedLockSingleton d2 = DoubleCheckedLockSingleton.getInstance();
    System.out.println(d1.hashCode());
    System.out.println(d1==d2);

    BillPughSingleton b1 = BillPughSingleton.getInstance();
    BillPughSingleton b2 = BillPughSingleton.getInstance();
    System.out.println(b1==b2);

    EnumSingleton enum1 = EnumSingleton.getInstance();
    EnumSingleton enum2 = EnumSingleton.getInstance();
    System.out.println(enum1==enum2);

    // Breaking singleton using reflection
    Constructor<DoubleCheckedLockSingleton> constructor = DoubleCheckedLockSingleton.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    DoubleCheckedLockSingleton reflectionObj = constructor.newInstance();
    System.out.println(reflectionObj.hashCode());

    // Breaking singleton serialization
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C://fil.ser"));
    out.writeObject(d1);
    out.close();

    ObjectInputStream inp = new ObjectInputStream(new FileInputStream("C://fil.ser"));
    DoubleCheckedLockSingleton serilaizedObj = (DoubleCheckedLockSingleton) inp.readObject();
    System.out.println(d1.hashCode());
    System.out.println(serilaizedObj.hashCode());

    // Breaking singleton using cloning
    DoubleCheckedLockSingleton clonedSingleton = (DoubleCheckedLockSingleton) d1.clone();
    System.out.println(clonedSingleton.hashCode());
}
