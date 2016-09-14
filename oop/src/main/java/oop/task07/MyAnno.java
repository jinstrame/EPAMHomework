package oop.task07;


import java.lang.annotation.*;

/**
 * Annotation describes module and task through JavaFundamentals course
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String module();
    int task();
}
