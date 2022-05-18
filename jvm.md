# JVM常用配置

``xml
-Xms512m #Java堆容量
-Xmx512m #Java堆最大容量，通常设置成跟初始值一样，避免动态扩展
-Xmn128m #新生代容量（频繁发生GC的地方），【这个可以不设置，给它自由，包含在堆容量里】
-XX:PermSize=128m #永久堆（这个也要注意，空间满了也会触发Full GC！！！）
-XX:MaxPermSize=128m #永久堆最大容量
-XX:MetaspaceSize=750m
-XX:MaxMetaspaceSize=750m

-Xverify:none #影响 Class Loader Time

-XX:+DisableExplicitGC #显式GC System.gc() 是没有必要的，可通过该选项来屏蔽或者说禁止
``

## JMX远程控制
``
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.port=8578
-Dcom.sun.management.jmxremote.rmi.port=8578
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.ssl=false
``

## GC
``
-XX:+PrintGC #输出GC日志
-XX:+PrintGCDetails #输出GC的详细日志
-XX:+PrintGCTimeStamps #输出GC的时间戳（以基准时间的形式）
-XX:+PrintGCDateStamps #输出GC的时间戳（2013-05-04T21:53:59.234+0800），JDK6有效，Open JDK11无效！！！
-XX:+PrintHeapAtGC #在进行GC的前后打印出堆的信息
-Xloggc:../../gc.log #这样日志就在IDEA的安装根目录下
``