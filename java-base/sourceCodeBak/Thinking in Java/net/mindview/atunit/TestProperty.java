package com.books.book03.net.mindview.atunit;
//: net/mindview/atunit/TestProperty.java
// The @Unit @TestProperty tag.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Both fields and methods may be tagged as properties:
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestProperty {
} ///:~
