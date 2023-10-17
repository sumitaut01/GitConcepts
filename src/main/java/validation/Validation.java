package validation;

import java.lang.reflect.InvocationTargetException;

public interface Validation<T>  {

    //boolean validate(T data);

    public  Validation validateBJ();

    // Factory method to create and return instances of the class passed as an argument
     Validation<T> create(Class<? extends Validation<T>> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}