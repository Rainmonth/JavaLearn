package com.rainmonth.basic.refect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 获取对象 Field 列表
 * <ul>
 *     <li>{@link #listField(Object)}</li>
 *     <li>{@link #listField(Object, boolean)} </li>
 *     <li>{@link #listField(Class, boolean)}</li>
 * </ul>
 * 根据名称获取Field
 * <ul>
 *     <li>{@link #getField(Object, String)}</li>
 *     <li>{@link #getField(Class, String)}</li>
 * </ul>
 * 设置Field的值
 * <ul>
 *     <li>{@link #setField(Object, String, Object)}</li>
 *     <li>{@link #setStaticField(Object, String, Object)}</li>
 * </ul>
 * 根据方法名获取方法
 * <ul>
 *     <li>{@link #getMethod(Class, String, Class[])}</li>
 *     <li>{@link #getDeclaredMethod(Class, String, Class[])}</li>
 * </ul>
 * 获取构造方法、调用构造方法
 * <ul>
 *     <li>{@link #getConstructor(Class, Class[])}</li>
 *     <li>{@link #invokeConstructor(Class, Object[], Class[])}</li>
 * </ul>
 * 创建对象实例
 * <ul>
 * <li>{@link #newInstance(Class)}</li>
 * </ul>
 *
 * @author RandyZhang
 * @date 2021/9/3 3:11 下午
 */
public class ReflectUtils {
    /**
     * 获取 object 的Field列表
     *
     * @param object 对象
     * @return object 的Field列表
     */
    public static List<Field> listField(Object object) {
        return listField(object.getClass(), true);
    }

    /**
     * 获取 object 的Field列表
     *
     * @param object       对象
     * @param includeSuper 是否包含父类的Field列表
     * @return object 的Field列表
     */
    public static List<Field> listField(Object object, boolean includeSuper) {
        return listField(object.getClass(), includeSuper);
    }

    /**
     * 获取 class 的Field列表
     *
     * @param clazz        对象的class
     * @param includeSuper 是否包含父类的Field列表
     * @return class 的Field列表
     */
    public static List<Field> listField(Class<?> clazz, boolean includeSuper) {
        List<Field> fieldList = new ArrayList<>();
        try {
            Field[] fields = clazz.getDeclaredFields();
            // Arrays.asList()返回的是定长ArrayList，不能修改
            fieldList.addAll(Arrays.asList(fields));
            if (includeSuper) {
                if (clazz.getSuperclass() != null) {
                    fieldList.addAll(listField(clazz.getSuperclass(), true));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fieldList;
    }

    public static Field getField(Object object, String fieldName) {
        return getField(object.getClass(), fieldName);
    }

    public static Field getField(Class<?> clazz, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        if (clazz.getSuperclass() != null) {
            return getField(clazz.getSuperclass(), fieldName);
        }
        return null;
    }

    public static void setField(Object object, String fieldName, Object fieldNewValue) {
        Field field = getField(object, fieldName);
        try {
            if (field != null) {
                field.setAccessible(true);
                field.set(object, fieldNewValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Field getDeclaredField(Class<?> clazz, String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return field;
    }

    public static <R> R getStaticField(Object object, String fieldName) {
        return getStaticField(object.getClass(), fieldName);
    }

    public static <R> R getStaticField(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            makeFieldVeryAccessible(field);
            return (R) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void makeFieldVeryAccessible(Field field) {
        field.setAccessible(true);
    }

    public static void setStaticField(Object object, String fieldName, Object fieldNewValue) {
        setStaticField(object.getClass(), fieldName, fieldNewValue);
    }

    public static void setStaticField(Class<?> clazz, String fieldName, Object fieldNewValue) {
        try {
            clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... args) {
        Method method = null;
        Method[] methods = clazz.getDeclaredMethods();
        try {
            for (Method m : methods) {
                if (!m.getName().equals(methodName)) {
                    continue;
                }
                Class<?>[] parameterTypes = m.getParameterTypes();
                // 判断传递的参数个数是否与方法的参数个数相同
                if (parameterTypes.length == args.length) {
                    boolean isSameMethod = true;
                    // 判断参数类型是否相同
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Class<?> arg = args[i];
                        if (!parameterTypes[i].equals(arg)) {
                            isSameMethod = false;
                            break;
                        }
                    }
                    // 这里不需要判断返回值，因为Java语言规范无法根据返回类型来区分重载
                    if (isSameMethod) {
                        method = m;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method;
    }

    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... args) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return method;

    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
        try {
            return clazz.getConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T invokeConstructor(Class<T> clazz, Object[] parameters, Class<?>... parameterTypes) {
        Constructor<T> constructor = null;
        if (parameters == null || parameterTypes == null) {
            constructor = getConstructor(clazz);
        } else {
            if (parameters.length != parameterTypes.length) {
                throw new IllegalArgumentException("parameters.length != parameterTypes.length");
            } else {
                constructor = getConstructor(clazz, parameterTypes);
            }
        }
        if (constructor == null) {
            return null;
        }

        try {
            return constructor.newInstance(parameters);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Annotation[] getClassAnnotations(Class<?> clazz) {
        try {
            return clazz.getAnnotations();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Annotation getClassAnnotation(Class<?> clazz, Class<? extends Annotation> aClazz) {
        try {
            return clazz.getAnnotation(aClazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Annotation[] getFieldAnnotations(Class<?> clazz, String fieldName) {
        try {
            Field field = getField(clazz, fieldName);
            if (field != null) {
                return field.getAnnotations();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Annotation getFieldAnnotation(Class<?> clazz, String fieldName, Class<? extends Annotation> aClazz) {
        try {
            Field field = getField(clazz, fieldName);
            if (field != null) {
                return field.getAnnotation(aClazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Annotation[] getMethodAnnotations(Class<?> clazz, String methodName) {
        try {
            Method method = getMethod(clazz, methodName);
            if (method != null) {
                return method.getAnnotations();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Annotation getMethodAnnotation(Class<?> clazz, String methodName, Class<? extends Annotation> aClazz) {
        try {
            Method method = getMethod(clazz, methodName);
            if (method != null) {
                return method.getAnnotation(aClazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive();
    }

}
