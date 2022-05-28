# ch01

# ch07
## 7.3.5 初始化
- 类构造器 <clinit>()
  - 静态变量和静态代码块`static{}`
  - 按代码的编写顺序编译执行
  - 类（class）先执行父类的类构造器，见[SuperFirstRef.java](com/youngzy/ch07/SuperFirstRef.java)和[SuperFirstNoRef.java](com/youngzy/ch07/SuperFirstNoRef.java)
  - 接口（interface）除非有引用，否则不执行父类构造器
  - 多线程环境中，虚拟机会保证类构造器被正确加载，如果<clinit>执行时间过长，会造成线程阻塞，见[ClassInitBlock.java](com/youngzy/ch07/ClassInitBlock.java)
# ch08
- 方法重载 Overload
  - 按定义的类型区分，而不是实际类型，见[MethodOverloadResolution.java](com/youngzy/ch08/MethodOverloadResolution.java)
  - 如果没有定义类型，自动向上匹配
  - 优先级（见[OverloadPriority.java](com/youngzy/ch08/OverloadPriority.java)）：
    - char
    - int
    - long
    - float
    - double
    - Character
    - interface
    - Object
    - char... （变长参数优先级最低）
- 重载（Overload） VS 覆写（Override）  
  - 
    |重载|覆写|
    |---|---|
    |同一个方法名不同的参数类型|发生在继承关系中，子类覆盖父类中的方法|
    |父子类是参数|父子类是Receiver|

## ch12
- `volatile`
  - 适合修饰标记变量，如"是否已完成"，"是否已初始化"等，见[VolatileDemo4.java](com/youngzy/ch12/VolatileDemo4.java)
  - 不适合用作计数器，即当前值会影响计算结果