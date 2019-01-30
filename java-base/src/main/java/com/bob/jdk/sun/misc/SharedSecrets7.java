package com.bob.jdk.sun.misc;

import sun.misc.JavaAWTAccess;
import sun.misc.JavaIOAccess;
import sun.misc.JavaIOFileDescriptorAccess;
import sun.misc.JavaNetAccess;
import sun.misc.JavaNetHttpCookieAccess;
import sun.misc.JavaNioAccess;
import sun.misc.JavaSecurityAccess;
import sun.misc.JavaSecurityProtectionDomainAccess;
import sun.misc.JavaUtilJarAccess;
import sun.misc.JavaUtilZipFileAccess;
import sun.misc.Unsafe;

import java.io.Console;
import java.io.FileDescriptor;
import java.net.HttpCookie;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.ProtectionDomain;
import java.util.jar.JarFile;
import java.util.zip.Adler32;
import java.util.zip.ZipFile;
import javax.security.auth.kerberos.KeyTab;

public class SharedSecrets7 {

  private static final Unsafe unsafe = Unsafe.getUnsafe();
  private static JavaUtilJarAccess javaUtilJarAccess;
  private static JavaLangAccess7 javaLangAccess;
  private static JavaIOAccess javaIOAccess;
  private static JavaNetAccess javaNetAccess;
  private static JavaNetHttpCookieAccess javaNetHttpCookieAccess;
  private static JavaNioAccess javaNioAccess;
  private static JavaIOFileDescriptorAccess javaIOFileDescriptorAccess;
  private static JavaSecurityProtectionDomainAccess javaSecurityProtectionDomainAccess;
  private static JavaSecurityAccess javaSecurityAccess;
  private static JavaxSecurityAuthKerberosAccess7 javaxSecurityAuthKerberosAccess;
  private static JavaUtilZipAccess7 javaUtilZipAccess;
  private static JavaUtilZipFileAccess javaUtilZipFileAccess;
  private static JavaAWTAccess javaAWTAccess;

  public SharedSecrets7() {
  }

  public static JavaUtilJarAccess javaUtilJarAccess() {
    if (javaUtilJarAccess == null) {
      unsafe.ensureClassInitialized(JarFile.class);
    }

    return javaUtilJarAccess;
  }

  public static void setJavaUtilJarAccess(JavaUtilJarAccess var0) {
    javaUtilJarAccess = var0;
  }

  public static void setJavaLangAccess(JavaLangAccess7 var0) {
    javaLangAccess = var0;
  }

  public static JavaLangAccess7 getJavaLangAccess() {
    return javaLangAccess;
  }

  public static void setJavaNetAccess(JavaNetAccess var0) {
    javaNetAccess = var0;
  }

  public static JavaNetAccess getJavaNetAccess() {
    return javaNetAccess;
  }

  public static void setJavaNetHttpCookieAccess(JavaNetHttpCookieAccess var0) {
    javaNetHttpCookieAccess = var0;
  }

  public static JavaNetHttpCookieAccess getJavaNetHttpCookieAccess() {
    if (javaNetHttpCookieAccess == null) {
      unsafe.ensureClassInitialized(HttpCookie.class);
    }

    return javaNetHttpCookieAccess;
  }

  public static void setJavaNioAccess(JavaNioAccess var0) {
    javaNioAccess = var0;
  }

  public static JavaNioAccess getJavaNioAccess() {
    if (javaNioAccess == null) {
      unsafe.ensureClassInitialized(ByteOrder.class);
    }

    return javaNioAccess;
  }

  public static void setJavaIOAccess(JavaIOAccess var0) {
    javaIOAccess = var0;
  }

  public static JavaIOAccess getJavaIOAccess() {
    if (javaIOAccess == null) {
      unsafe.ensureClassInitialized(Console.class);
    }

    return javaIOAccess;
  }

  public static void setJavaIOFileDescriptorAccess(JavaIOFileDescriptorAccess var0) {
    javaIOFileDescriptorAccess = var0;
  }

  public static JavaIOFileDescriptorAccess getJavaIOFileDescriptorAccess() {
    if (javaIOFileDescriptorAccess == null) {
      unsafe.ensureClassInitialized(FileDescriptor.class);
    }

    return javaIOFileDescriptorAccess;
  }

  public static void setJavaSecurityProtectionDomainAccess(JavaSecurityProtectionDomainAccess var0) {
    javaSecurityProtectionDomainAccess = var0;
  }

  public static JavaSecurityProtectionDomainAccess getJavaSecurityProtectionDomainAccess() {
    if (javaSecurityProtectionDomainAccess == null) {
      unsafe.ensureClassInitialized(ProtectionDomain.class);
    }

    return javaSecurityProtectionDomainAccess;
  }

  public static void setJavaSecurityAccess(JavaSecurityAccess var0) {
    javaSecurityAccess = var0;
  }

  public static JavaSecurityAccess getJavaSecurityAccess() {
    if (javaSecurityAccess == null) {
      unsafe.ensureClassInitialized(AccessController.class);
    }

    return javaSecurityAccess;
  }

  public static void setJavaxSecurityAuthKerberosAccess(JavaxSecurityAuthKerberosAccess7 var0) {
    javaxSecurityAuthKerberosAccess = var0;
  }

  public static JavaxSecurityAuthKerberosAccess7 getJavaxSecurityAuthKerberosAccess() {
    if (javaxSecurityAuthKerberosAccess == null) {
      unsafe.ensureClassInitialized(KeyTab.class);
    }

    return javaxSecurityAuthKerberosAccess;
  }

  public static void setJavaUtilZipAccess(JavaUtilZipAccess7 var0) {
    javaUtilZipAccess = var0;
  }

  public static JavaUtilZipAccess7 getJavaUtilZipAccess() {
    if (javaUtilZipAccess == null) {
      unsafe.ensureClassInitialized(Adler32.class);
    }

    return javaUtilZipAccess;
  }

  public static JavaUtilZipFileAccess getJavaUtilZipFileAccess() {
    if (javaUtilZipFileAccess == null) {
      unsafe.ensureClassInitialized(ZipFile.class);
    }

    return javaUtilZipFileAccess;
  }

  public static void setJavaUtilZipFileAccess(JavaUtilZipFileAccess var0) {
    javaUtilZipFileAccess = var0;
  }

  public static void setJavaAWTAccess(JavaAWTAccess var0) {
    javaAWTAccess = var0;
  }

  public static JavaAWTAccess getJavaAWTAccess() {
    return javaAWTAccess;
  }
}
