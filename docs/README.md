## 1. 基础概念

注解是一系列元数据，它提供数据用来解释程序代码，但是注解并非是所解释的代码本身的一部分

注解对于代码的运行效果没有直接影响

注解有许多用处，主要如下： 

* 提供信息给编译器： 

    编译器可以利用注解来探测错误和警告信息
 
* 编译阶段时的处理： 

    软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理
 
* 运行时的处理： 

    某些注解可以在程序运行的时候接受代码的提取

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

Target 是目标的意思，@Target 指定了注解运用的地方

当一个注解被 @Target 标记时，这个注解就被限定了运用的场景

@Target 有下面的取值

* ElementType.ANNOTATION_TYPE 

    可以给一个注解进行注解

* ElementType.CONSTRUCTOR 

    可以给构造方法进行注解

* ElementType.FIELD 

    可以给属性进行注解

* ElementType.LOCAL_VARIABLE 

    可以给局部变量进行注解

* ElementType.METHOD 

    可以给方法进行注解

* ElementType.PACKAGE 

    可以给一个包进行注解

* ElementType.PARAMETER 

    可以给一个方法内的参数进行注解

* ElementType.TYPE 

    可以给一个类型进行注解，比如类、接口、枚举

#### 1.1.4 @Inherited

Inherited 是继承的意思，但是它并不是说注解本身可以继承

而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解
 
示例代码：

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Test {}
    
    @Test
    public class A {}
    
    public class B extends A {}

注解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解

#### 1.1.5 @Repeatable

Repeatable 是可重复的意思

@Repeatable 是 Java 1.8 才加进来的一个新特性

什么样的注解会多次应用呢？通常是注解的值可以同时取多个

举个例子，一个人他既是程序员又是产品经理,同时他还是个画家
    
    @interface Persons {
        Person[]  value();
    }
    
    
    @Repeatable(Persons.class)
    @interface Person{
        String role default "";
    }
    
    
    @Person(role="artist")
    @Person(role="coder")
    @Person(role="PM")
    public class SuperMan{
    
    }

注意上面的代码，@Repeatable 注解了 Person。而 @Repeatable 后面括号中的类相当于一个容器注解

什么是容器注解呢？就是用来存放其它注解的地方，它本身也是一个注解

我们再看看代码中的相关容器注解

    @interface Persons {
        Person[]  value();
    }

按照规定，它里面必须要有一个 value 的属性，属性类型是一个被 @Repeatable 注解过的注解数组，注意它是数组

如果不好理解的话，可以这样理解：

Persons 是一张总的标签，上面贴满了 Person 这种同类型但内容不一样的标签

把 Persons 给一个 SuperMan 贴上，相当于同时给他贴了程序员、产品经理、画家的标签

我们可能对于 @Person(role=”PM”) 括号里面的内容感兴趣，它其实就是给 Person 这个注解的 role 属性赋值为 PM

### 1.2 注解的属性

注解的属性也叫做成员变量

注解只有成员变量，没有方法

注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型

比如：
    
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnnotation {
    
        int id();
    
        String msg();
    
    }

上面代码定义了 TestAnnotation 这个注解中拥有 id 和 msg 两个属性

在使用的时候，我们应该给它们进行赋值

赋值的方式是在注解的括号内以 value = "" 形式，多个属性之间用 ',' 隔开

    @TestAnnotation(id = 3, msg = "hello annotation")
    public class Test {
    
    }

需要注意的是，在注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组

注解中属性可以有默认值，默认值需要用 default 关键值指定

比如：
    
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestAnnotation {
    
        public int id() default -1;
    
        public String msg() default "Hi";
    
    }

TestAnnotation 中 id 属性默认值为 -1, msg 属性默认值为 'Hi'
 
它也可以这样应用:

    @TestAnnotation()
    public class Test {}

因为@TestAnnotation的属性有默认值，所以无需要再在 @TestAnnotation 后面的括号里面进行赋值了，这一步可以省略

另外，还有一种情况

如果一个注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内

比如：

    public @interface Check {
        String value();
    }

上面代码中，Check 这个注解只有 value 这个属性。所以可以这样应用。

    @Check("hi")
    int a;

这和下面的效果是一样的

    @Check(value="hi")
    int a;

最后，还需要注意的一种情况是一个注解没有任何属性

比如：

    public @interface Perform {}

那么在应用这个注解的时候，括号都可以省略

    @Perform
    public void testMethod(){}

### 1.3 Java内置的注解

#### 1.3.1 @Deprecated

这个元素是用来标记过时的元素

编译器在编译阶段遇到这个注解时会发出提醒警告，告诉开发者正在调用一个过时的元素比如过时的方法、过时的类、过时的成员变量

    public class TestDeprecated {
    
        private Logger logger = LoggerFactory.getLogger(TestDeprecated.class);
    
        @Deprecated
        public void wrongMethod () {
            logger.warn("wrong method had been called");
        }
    
        public void correctMethod () {
            logger.info("hello world");
        }
    
    }

定义了一个 TestDeprecated 类，它有两个方法 wrongMethod() 和 correctMethod()，其中 wrongMethod() 被 @Deprecated 标记

然后我们在 IDE 中把下面这段代码加上：

    TestDeprecated testDeprecated = new TestDeprecated();
    testDeprecated.wrongMethod();
    testDeprecated.correctMethod();

可以看到，testDeprecated.wrongMethod()wrongMethod()方法上面被一条直线划了一条，这其实就是编译器识别后的提醒效果

#### 1.3.2 @Override

提示子类要复写父类中被 @Override 修饰的方法

#### 1.3.3 @SuppressWarnings

阻止警告的意思

之前说过调用被 @Deprecated 注解的方法后，编译器会警告提醒，而有时候开发者会忽略这种警告，他们可以在调用的地方通过 @SuppressWarnings 达到目的
    
    @SuppressWarnings("deprecation")
    public void test1(){
        Hero hero = new Hero();
        hero.say();
        hero.speak();
    }

#### 1.3.4 @SafeVarargs

参数安全类型注解

它的目的是提醒开发者不要用参数做一些不安全的操作,它的存在会阻止编译器产生 unchecked 这样的警告

它是在 Java 1.7 的版本中加入的

    @SafeVarargs // Not actually safe!
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

上面的代码中，编译阶段不会报错，但是运行时会抛出 ClassCastException 这个异常，所以它虽然告诉开发者要妥善处理，但是开发者自己还是搞砸了

Java 官方文档说，未来的版本会授权编译器对这种不安全的操作产生错误警告

#### 1.3.5 @FunctionalInterface

函数式接口注解，这个是 Java 1.8 版本引入的新特性

函数式编程很火，所以 Java 8 也及时添加了这个特性

函数式接口 (Functional Interface) 就是一个具有一个方法的普通接口

比如：
    
    @FunctionalInterface
    public interface Runnable {
        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see     java.lang.Thread#run()
         */
        public abstract void run();
    }

我们进行线程开发中常用的 Runnable 就是一个典型的函数式接口，上面源码可以看到它就被 @FunctionalInterface 注解

可能有人会疑惑，函数式接口标记有什么用，这个原因是函数式接口可以很容易转换为 Lambda 表达式

### 1.4 检测注解的存在

#### 1.4.1 获取类名上的注解信息

现在假设我们存在这样的一个注解：

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Inherited
    @Documented
    public @interface HumanAnnotation {
    
        String name ();
    
        String sex ();
    
        int age ();
    
    }

并将它应用到一个Man类上：

    @HumanAnnotation(name = "Zhangsan", sex = "boy", age = 18)
    public class Man {
    
    }
    
接下来的代码展示了如何判断Man类是否存在HumanAnnotation注解，并且将其属性取出：

    private static Logger logger = LoggerFactory.getLogger(Man.class);

    public static void main (String[] args) {
        boolean hasAnnotation = Man.class.isAnnotationPresent(HumanAnnotation.class);
        if (hasAnnotation) {
            HumanAnnotation humanAnnotation = Man.class.getAnnotation(HumanAnnotation.class);
            logger.info("a human named :  " + humanAnnotation.name());
            logger.info("a human who is a : " + humanAnnotation.sex());
            logger.info("a human who is : " + humanAnnotation.age() + " years old");
        }
    }
    
#### 1.4.2 获取属性、方法上的注解信息

现在假设我们存在两个注解：

* 作用于类属性上的：

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface FoodAnnotation {
        
            String value();
        
        }

* 作用于类方法上的：

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.METHOD)
        public @interface MoveFasterAnnotation {
        }

然后我们定义了一个新的类，并在其属性和方法上，应用了上述的两个注解：

    @HumanAnnotation(name = "XiaoJu", sex = "girl", age = 18)
    public class Woman {
    
        private static Logger logger = LoggerFactory.getLogger(Woman.class);
    
        @FoodAnnotation("apple")
        private String lovesFood;
    
        @MoveFasterAnnotation
        private void walk () {}
    
        @SuppressWarnings("deprecation")
        public void wrongMethod () {
            TestDeprecated testDeprecated = new TestDeprecated();
            testDeprecated.wrongMethod();
            testDeprecated.correctMethod();
        }
    
        public static void main (String[] args) {
            boolean hasAnnotation = Woman.class.isAnnotationPresent(HumanAnnotation.class);
    
            if (hasAnnotation) {
                HumanAnnotation humanAnnotation = Woman.class.getAnnotation(HumanAnnotation.class);
                logger.info("a human named: " + humanAnnotation.name());
                logger.info("a human who is a: " + humanAnnotation.sex());
                logger.info("a human who is:" + humanAnnotation.age() + " years old");
            }
    
            try {
                Field food = Woman.class.getDeclaredField("lovesFood");
                food.setAccessible(true);
    
                FoodAnnotation foodAnnotation = food.getAnnotation(FoodAnnotation.class);
    
                if (foodAnnotation != null) {
                    logger.info("the human loves to eat: " + foodAnnotation.value());
                }
    
                Method method = Woman.class.getDeclaredMethod("walk");
    
                if (method != null) {
                    Annotation[] ans = method.getDeclaredAnnotations();
                    for (Annotation annotation : ans) {
                        logger.info("the human has method: " + annotation.annotationType().getSimpleName());
                    }
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    
    }
    
通过对应的输出信息可以得到结论：

通过反射：getDeclaredField(${fieldName})和getDeclaredMethod(${methodName})获取到具体的字段和方法后，再利用getAnnotation()或者getDeclaredAnnotations()，便可以获取标记在类属性或者类方法上的注解

相关输出如下：    
    
    21:29:16.825 [main] INFO com.liumapp.blog.annotation.basic.Woman - a human named: XiaoJu
    21:29:16.828 [main] INFO com.liumapp.blog.annotation.basic.Woman - a human who is a: girl
    21:29:16.828 [main] INFO com.liumapp.blog.annotation.basic.Woman - a human who is:18 years old
    21:29:16.832 [main] INFO com.liumapp.blog.annotation.basic.Woman - the human loves to eat: apple
    21:29:16.835 [main] INFO com.liumapp.blog.annotation.basic.Woman - the human has method: MoveFasterAnnotation        

### 1.5 注解的使用场景

注解并不是代码本身的一部分，所以注解无法改变代码本身，注解只是某些工具的的工具

当开发者使用了Annotation 修饰了类、方法、Field 等成员之后，这些 Annotation 不会自己生效，必须由开发者提供相应的代码来提取并处理 Annotation 信息

这些处理提取和处理 Annotation 的代码统称为 APT（Annotation Processing Tool)

所以注解就是给APT或者编译器用的

在代码的com.liumapp.blog.annotation.exception下，有4个sample类及其注解，概括了一些基础的注解使用场景案例

## 2. 进阶用法

以Spring对注解的使用为例，观察一下Java注解的进阶用法

### 2.1 SpringBoot的自动配置


















