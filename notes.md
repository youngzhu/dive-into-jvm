# ch01

#ch07
## 7.3.5 初始化
- 类构造器 <clinit>()
  - 静态变量和静态代码块`static{}`
  - 按代码的编写顺序编译执行
  - 类（class）先执行父类的类构造器，见[SuperFirstRef.java](com/youngzy/ch07/SuperFirstRef.java)和[SuperFirstNoRef.java](com/youngzy/ch07/SuperFirstNoRef.java)
  - 接口（interface）除非有引用，否则不执行父类构造器
  - 多线程环境中，虚拟机会保证类构造器被正确加载，如果<clinit>执行时间过长，会造成线程阻塞，见[ClassInitBlock.java](com/youngzy/ch07/ClassInitBlock.java)