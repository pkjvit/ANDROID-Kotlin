package com.pkj.wow.androidkotlin.design_patterns.singleton;

/*
https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/?ref=rp
 */

import java.io.Serializable;

public class SingletonOvercomeReflectionSerializationCloning {
}

/**
 * Overcome reflection issue: To overcome issues raised by reflection,
 * enums are used because java ensures internally that the enum value is instantiated only once.
 * Since java Enums are globally accessible, they can be used for singletons.
 * Its only drawback is that it is not flexible i.e it does not allow lazy initialization.
 */

enum EnumSingleton {
    INSTANCE;
}


/*
Overcome serialization issue:- To overcome this issue,
we have to implement the method readResolve() method.
 */
class SerializableSingleton implements Serializable {

    // public instance initialized when loading the class
    public static SerializableSingleton instance = new SerializableSingleton();

    private SerializableSingleton()
    {
        // private constructor
    }

    // implement readResolve method
    protected Object readResolve() { return instance; }
}

/*
Overcome Cloning issue: To overcome this issue, override clone() method
and throw an exception from clone method that is CloneNotSupportedException.
Now, whenever user will try to create clone of singleton object,
it will throw an exception and hence our class remains singleton.

 */

// Singleton class
class CloneableSingleton implements Cloneable {

    // public instance initialized when loading the class
    public static CloneableSingleton instance = new CloneableSingleton();

    private CloneableSingleton()
    {
        // private constructor
    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}