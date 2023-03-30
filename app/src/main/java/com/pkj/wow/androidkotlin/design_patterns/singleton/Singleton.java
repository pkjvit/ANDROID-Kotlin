package com.pkj.wow.androidkotlin.design_patterns.singleton;

/**
 * 1. Eager initialization is easy to implement but it may cause resource and CPU time wastage.
 * Use it only if cost of initializing a class is less in terms of resources
 * or your program will always need the instance of class.
 * 2. By using Static block in Eager initialization we can provide exception handling
 * and also can control over instance.
 * 3. Using synchronized we can create singleton class in multi-threading environment
 * also but it can cause slow performance, so we can use Double check locking mechanism.
 *
 * 4. Bill Pugh implementation is most widely used approach for singleton classes.
 * Most developers prefer it because of its simplicity and advantages.
 */

// Eagar initialization
/*
Very simple to implement.
No need to implement getInstance() method. Instance can be accessed directly.
Exceptions can be handled in static block.
May lead to resource wastage. Because instance of class is created always, whether it is required or not.
CPU time is also wasted in creation of instance if it is not required.
 */
class EarlySingleton {
    private static final EarlySingleton SINGLETON = new EarlySingleton();
    private EarlySingleton(){}
    public static EarlySingleton getInstance(){
        return SINGLETON;
    }
}

// Lazy initialization
/*
Object is created only if it is needed. It may overcome wastage of resource and  CPU time.
Exception handling is also possible in method.
Every time a condition of null has to be checked.
instance can’t be accessed directly.
In multithreaded environment, it may break singleton property.
 */
class LazySingleton {
    private static LazySingleton SINGLETON;
    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(SINGLETON == null){
            SINGLETON = new LazySingleton();
        }
        return SINGLETON;
    }
}

/*
Lazy initialization is possible.
It is also thread safe.
getInstance() method is synchronized so it causes slow performance
as multiple threads can’t access it simultaneously.
 */
class ThreadSafeSingleton{
    private static ThreadSafeSingleton SINGLETON;
    private ThreadSafeSingleton(){}

    synchronized public static ThreadSafeSingleton getInstance(){
        if(SINGLETON == null){
            SINGLETON = new ThreadSafeSingleton();
        }
        return SINGLETON;
    }
}


/*
Lazy initialization is possible.
It is also thread safe.
Performance overhead gets reduced because of synchronized keyword.
First time, it can affect performance.
 */
class DoubleCheckThreadSafeSingleton{
    private static DoubleCheckThreadSafeSingleton SINGLETON;
    private DoubleCheckThreadSafeSingleton(){}

    public static DoubleCheckThreadSafeSingleton getInstance(){
        if(SINGLETON == null){
            synchronized (DoubleCheckThreadSafeSingleton.class){
                if(SINGLETON == null) {
                    SINGLETON = new DoubleCheckThreadSafeSingleton();
                }
            }
        }
        return SINGLETON;
    }
}

/*
When the singleton class is loaded, inner class is not loaded
and hence doesn’t create object when loading the class.
Inner class is created only when getInstance() method is called.
So it may seem like eager initialization but it is lazy initialization.
This is the most widely used approach as it doesn’t use synchronization.
 */
class BillPughSingleton{
    private static BillPughSingleton SINGLETON;
    private BillPughSingleton(){}

    // Inner class to provide instance of class
    private static class BillPughInnerSingleton
    {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance()
    {
        return BillPughInnerSingleton.INSTANCE;
    }
}



