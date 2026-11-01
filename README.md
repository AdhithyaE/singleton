Eager Singleton:
creates the instance when the class is loaded, making it inherently thread-safe, but the object is created even if it is never used.
Lazy Singleton:
creates the instance only when getInstance() is called, but the basic implementation is not thread-safe when multiple threads access it simultaneously.
Double-Checked:
Locking provides lazy initialization with thread safety by using synchronized only during instance creation; volatile is required for correct visibility and initialization.
Bill Pugh Singleton:
uses a static inner holder class to achieve lazy initialization and thread safety without explicit synchronization, making it simple and efficient.
Enum Singleton:
uses a Java enum to provide a thread-safe, serialization-safe, and reflection-resistant Singleton with minimal code; it is generally the simplest robust approach.

| Pattern                | Lazy | Thread-safe | Complexity   |
| ---------------------- | ---- | ----------- | ------------ |
| Eager                  | ❌    | ✅           | Low          |
| Basic Lazy             | ✅    | ❌           | Low          |
| Double-Checked Locking | ✅    | ✅           | Medium       |
| Bill Pugh              | ✅    | ✅           | Low          |
| **Enum**               | —    | ✅           | **Very Low** |

For Singleton, reflection and cloning are important because both can potentially create another object.

Reflection:
Java reflection can access a private constructor and create another instance, breaking a normal Singleton. 
Enum Singleton is strongly protected against reflection-based instantiation.

Constructor<Singleton> constructor =
        Singleton.class.getDeclaredConstructor();

constructor.setAccessible(true);

Singleton s2 = constructor.newInstance();


public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("Singleton already exists");
        }
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

Cloning: If a Singleton implements Cloneable, clone() can create another object and break Singleton.
A class-based Singleton should prevent this by overriding clone() and throwing CloneNotSupportedException.


     @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }

    
Interview point
Singleton	Reflection	Cloning
Eager	⚠️ Can break	⚠️ Can break if Cloneable
Lazy	⚠️ Can break	⚠️ Can break if Cloneable
Double-Checked	⚠️ Can break	⚠️ Can break if Cloneable
Bill Pugh	⚠️ Can break	⚠️ Can break if Cloneable
Enum	✅ Protected	✅ Naturally protected



