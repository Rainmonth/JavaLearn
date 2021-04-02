package com.rainmonth.basic;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author randy
 * @date 2021/4/1 7:27 下午
 */
public class RefDemo {
    public static void main(String[] args) {
        // 此时 obj 就被强引用了，Jvm 在垃圾回收时不会回收obj，因为他被obj1强引用了，要想让垃圾收集器回收它，需要将obj置空
        Object obj = new Object();
        Object obj1 = obj;
        // obj = null

        Object obj2 = new Object();
        // 此时 obj2 就被软引用了，在Jvm 内存不足的时候，obj2 会被GC回收；在内存充足的情况下，obj2 不会被回收，可正常使用；
        SoftReference<Object> objectSoftReference = new SoftReference<>(obj2);
        Object result2 = objectSoftReference.get();

        Object obj3 = new Object();
        // 此时 obj3 就被弱引用了，在JVM gc的时候，obj3 会被回收，不管内存是否充足
        WeakReference<Object> objectWeakReference = new WeakReference<>(obj3);

        Object obj4 = new Object();
        // 和没有使用没啥区别，不会影响对象的生命周期，GC在回收obj4的时候，发现它有虚引用，会先把该虚引用会加入到ReferenceQueue中，通过扫描
        // ReferenceQueue 中是否有objectPhantomReference，就可以判断 obj4 是否将要被回收了
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> objectPhantomReference = new PhantomReference<>(obj4, referenceQueue);
    }
}
