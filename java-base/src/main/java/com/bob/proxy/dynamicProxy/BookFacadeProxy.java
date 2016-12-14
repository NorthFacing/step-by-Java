package com.bob.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Bob on 2016/12/14.
 */
public class BookFacadeProxy implements InvocationHandler {
  private Object target;

  public Object newInstance(Object target) {
    this.target = target;
    //Get the proxy object
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);   //To bind interface (this is a defect, cglib made up for this shortcoming)
  }

  @Override
  // The callback method
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("The start of something");
    //Execution method
    Object result = method.invoke(target, args);
    System.out.println("End of things");
    return result;
  }

}