# spring aop + druid 动态切换数据库
## 应用知识点
### 动态切换数据库
**AbstractRoutingDataSource**：其底层`resolvedDefaultDataSource`用来存储默认使用的数据源，当继承该类时，需要实现`determineCurrentLookupKey`
方法，该方法用于获取需要使用的数据源的key，每次通过key取出数据
<br/>
**aop**: 使用spring的aop注解，创建注解，每次要执行数据库录入时都会将当前注解标注的数据库的名称存入`ThreadLocal`中。并由动态数据源调用取出

