## 1. 基础概念

### 1.1 元注解

元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面

它也是一张标签，但是它是一张特殊的标签，它的作用和目的就是给其他普通的标签进行解释说明的

元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种

#### 1.1.1 @Retention

Retention 的英文意为保留期的意思

当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间

它的取值如下：
 
* RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视
 
* RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中
 
* RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们

#### 1.1.2 @Documented

顾名思义，这个元注解肯定是和文档有关

它的作用是能够将注解中的元素包含到 Javadoc 中去

#### 1.1.3 @Target



#### 1.1.4 @Inherited

#### 1.1.5 @Repeatable