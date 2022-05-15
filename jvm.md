# JVM常用配置

``xml
-Xmn128m #新生代容量（频繁发生GC的地方）
-Xms512m #Java堆容量
-Xmx512m #Java堆最大容量，通常设置成跟初始值一样，避免动态扩展
-XX:PermSize=128m #永久堆
-XX:MaxPermSize=128m #永久堆最大容量

-XX:+DisableExplicitGC #显式GC System.gc() 是没有必要的，可通过该选项来屏蔽或者说禁止
``