package com.wheeler.core.utility;

import com.wheeler.core.dto.model.FieldDto;
import com.wheeler.core.dto.model.helper.Argument;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class ReflectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtil.class);

    /**
     * Constructs a new instance of the provided class by accessing its no-args constructor.
     *
     * @param clazz The class to instantiate.
     * @param <T> Any object.
     * @return The constructed class.
     */
    public static <T> T construct(final Class<T> clazz){
        try {
            return clazz.getConstructor().newInstance();
        }
        catch (IllegalAccessException
                | InstantiationException
                | InvocationTargetException
                | NoSuchMethodException e
        ) {
            final String message = String.format("construct(Class) error: %s", e);
            LOGGER.error(message);
            throw new IllegalStateException(message);
        }
    }

    /**
     * Constructs a new instance of the provided class by accessing its no-args constructor. Populates its fields
     * against the properties map provided. The Map#getKey() must match the field name exactly. The corresponding value
     * will be sent into field setter with **no type checking**.
     *
     * @param clazz The class to instantiate.
     * @param properties The properties to populate.
     * @param <T> Any object.
     * @return The constructed class.
     */
    public static <T> T construct(final Class<T> clazz, final Map<String, Object> properties){
        final T instance = construct(clazz);
        propertiesStream(clazz).forEach(p -> {
            final Object value = properties.get(p.getName());
            setPropertyValue(p, instance, value);
        });
        return instance;
    }

    /**
     * Reflect on the class to provide a List of FieldDto instances. When a class instance is not provided the
     * FieldDto#getValue() will always return null since it's impossible to invoke the getter method without a class
     * instance.
     *
     * @param clazz The class to reflect.
     * @return List of FieldDto instances.
     */
    public static List<FieldDto> describe(final Class<?> clazz){
        return propertiesStream(clazz)
                .map(p -> new FieldDto(p.getName(), p.getPropertyType(), null))
                .collect(Collectors.toList());
    }

    /**
     * Reflect on the class to provide a List of FieldDto instances.
     *
     * @param instance An object instance to reflect.
     * @return List of FieldDto instances.
     */
    public static List<FieldDto> describe(final Object instance){
        return propertiesStream(instance.getClass())
                .map(p -> {
                    final Object value = getPropertyValue(p, instance);
                    return new FieldDto(p.getName(), p.getPropertyType(), value);
                })
                .collect(Collectors.toList());
    }

    /**
     * Finds the provided annotation on the instance class.
     *
     * @param annotation the annotation to search for.
     * @param instanceClass the instance class to search.
     * @param <A> any annotation.
     * @return the annotation found.
     */
    public static <A extends Annotation> A getAnnotation(final Class<A> annotation, final Class<?> instanceClass){
        ValidationUtil.arguments(
            new Argument<>("annotation", annotation),
            new Argument<>("instanceClass", instanceClass)
        );
        return instanceClass.getAnnotation(annotation);
    }

    /**
     * Finds the provided annotation on the instance class.
     *
     * @param annotation the annotation to search for.
     * @param instance the instance of the class to search.
     * @param <A> any annotation.
     * @return the annotation found.
     */
    public static <A extends Annotation> A getAnnotation(final Class<A> annotation, final Object instance){
        return getAnnotation(annotation, instance != null ? instance.getClass() : null);
    }

    /**
     * Reflect on the class to provide a Map representation.
     * Map#getKey() will return the name of the field.
     * Map#getValue() will return the value of the field.
     *
     * @param instance An object instance to reflect.
     * @return Map representation of the object instance.
     */
    public static Map<String, Object> toMap(final Object instance){
        return describe(instance).stream().collect(Collectors.toMap(FieldDto::getName, FieldDto::getValue));
    }


    private static BeanInfo getBeanInfo(final Class<?> clazz){
        try {
            return Introspector.getBeanInfo(clazz);
        }
        catch(IntrospectionException e){
            final String message = String.format("describe(Object) IntrospectionException: %s", e);
            LOGGER.error(message);
            throw new IllegalStateException(message);
        }
    }

    private static Object getPropertyValue(final PropertyDescriptor descriptor, final Object instance) {
        try {
            return descriptor.getReadMethod().invoke(instance);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            final String message = String.format("getPropertyDescriptorValue(PropertyDescriptor, Object) error: %s", e);
            LOGGER.error(message);
            throw new IllegalStateException(message);
        }
    }

    private static Stream<PropertyDescriptor> propertiesStream(final Class<?> clazz){
        final BeanInfo info = getBeanInfo(clazz);
        return Arrays
                .stream(info.getPropertyDescriptors())
                .filter(d -> !"class".equals(d.getName()));
    }

    private static void setPropertyValue(
        final PropertyDescriptor descriptor, final Object instance, final Object value
    ){
        Object newValue = value;
        final Class<?> type = descriptor.getPropertyType();
        if(type.isEnum() && value instanceof String){
            newValue = Enum.valueOf((Class<Enum>)type, (String)value);
        }
        try {
            descriptor.getWriteMethod().invoke(instance, newValue);
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            final String message = String.format("setPropertyValue(PropertyDescriptor, Object, Object) error: %s", e);
            LOGGER.error(message);
            throw new IllegalStateException(message);
        }
    }
}
