# tx

## 主要功能

`通过@Transaction实现注解事务`

## 附加功能

`通过继承Interceptor可以实现前置、后置过滤。`

## maven

```xml
<repositories>
	<repository>
		<id>Jokerblazes-connection</id>
		<url>https://raw.github.com/Jokerblazes/maven-project/master/com</url>
	</repository>
</repositories>

<dependency>
      <artifactId>connection</artifactId>
      <groupId>com.joker</groupId>
      <version>0.0.1-SNAPSHOT</version>
</dependency>
```



## demo

```java
@Transaction
public List<User> test();
```

