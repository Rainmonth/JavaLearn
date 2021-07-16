package com.rainmonth.pattern.creational.prototype.checkout;

import com.rainmonth.pattern.creational.prototype.simple.AbsPrototype;
import com.rainmonth.pattern.creational.prototype.simple.RealPrototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author randy
 * @date 2021/7/16 2:22 下午
 */
public class PrototypeManager {
    public static final String PROTOTYPE_REAL = "real";
    public static final String PROTOTYPE_ANOTHER = "another";
    private static volatile PrototypeManager instance;

    public static PrototypeManager getInstance() {
        if (instance == null) {
            synchronized (PrototypeManager.class) {
                if (instance == null) {
                    instance = new PrototypeManager();
                }
            }
        }
        return instance;
    }

    private PrototypeManager() {
        this.prototypeMap = new HashMap<>();
    }

    private final Map<String, AbsPrototype> prototypeMap;

    public void removePrototype(String prototypeId) {
        prototypeMap.remove(prototypeId);
    }

    public AbsPrototype getPrototype(String prototypeId) {
        AbsPrototype absPrototype = prototypeMap.get(prototypeId);
        if (absPrototype == null) {
            if (PROTOTYPE_REAL.equals(prototypeId)) {
                absPrototype = new RealPrototype();
                prototypeMap.put(PROTOTYPE_REAL, absPrototype);
            } else if (PROTOTYPE_ANOTHER.equals(prototypeId)){
                absPrototype = new AnotherPrototype();
                prototypeMap.put(PROTOTYPE_ANOTHER, absPrototype);
            } else {
                throw new IllegalArgumentException("prototypeId:" + prototypeId + " not supported, please check it out!");
            }
        }
        return absPrototype;
    }
}
