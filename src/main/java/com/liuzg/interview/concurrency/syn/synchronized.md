
#### 锁

* 对象锁: 使用 synchronized 修饰非静态的方法以及 synchronized(this) 同步代码块使用的锁是对象锁。
* 类锁：使用 synchronized 修饰静态的方法以及 synchronized(class) 同步代码块使用的锁是类锁。
* 私有锁：在类内部声明一个私有属性如private Object lock，在需要加锁的同步块使用 synchronized(lock）

