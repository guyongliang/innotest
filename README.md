# innotest

- 隔离级别
    项目的隔离级别是由mysql默认的隔离级别决定的，我们可以通过 
    set [global|session] transaction isolation level read committed;
    来指定全局或当前会话的隔离级别
    select @@tx_isolation;查看当前会话隔离级别
    select @@global.tx_isolation;查看全局隔离级别
    修改启动时的隔离级别，那就得修改mysql的配置文件，在[mysqld]中添加
    ```[mysqld] transaction-isolation = read-committed```
    
总结：SpringBoot项目中的隔离级别是由mysql全局隔离级别决定的，
    所以在@Transaction注解中添加isolation=Transaction.READ_COMMITTED
    并不会起作用
    
    
    TransactionAspectSupport
    AbstractPlatformTransactionManager
    
    事务的隔离级别是数据库本身的事务功能，然而事务的传播属性则是Spring自己为我们提供的功能，数据库事务没有事务的传播属性这一说法。
    
    事务的隔离级别是数据库本身的事务功能，然而事务的传播属性则是Spring自己为我们提供的功能，数据库事务没有事务的传播属性这一说法。
    
    该接口的实现DefaultTransactionDefinition：默认的事务定义
    
    public class DefaultTransactionDefinition implements TransactionDefinition, Serializable {
    	private int propagationBehavior = PROPAGATION_REQUIRED;
    	private int isolationLevel = ISOLATION_DEFAULT;
    	private int timeout = TIMEOUT_DEFAULT;
    	private boolean readOnly = false;
    	//略
    }
    事务的传播属性为PROPAGATION_REQUIRED，即当前没有事务的时候，创建一个，如果有则使用当前事务
    事务的隔离级别采用底层数据库默认的隔离级别
    超时时间采用底层数据库默认的超时时间
    是否只读为false

SHOW GLOBAL VARIABLES LIKE 'innodb_lock_wait_timeout';


# 查询全局等待事务锁超时时间
SHOW GLOBAL VARIABLES LIKE 'innodb_lock_wait_timeout';

# 设置全局等待事务锁超时时间
SET  GLOBAL innodb_lock_wait_timeout=100;


# 查询当前会话等待事务锁超时时间
SHOW VARIABLES LIKE 'innodb_lock_wait_timeout';

一致性确保事务只能将数据库从一个有效状态带到另一个有效状态，从而维护数据库不变量：写入数据库的任何数据必须根据所有定义的规则有效，包括约束，级联，触发器及其任何组合。这可以防止非法事务导致数据库损坏，但不能保证事务是正确的。

> 一致性是一个非常通用的术语，它要求数据必须满足所有验证规则。在前面的示例中，验证是A + B = 100的要求。必须检查所有验证规则以确保一致性。假设事务试图从A中减去10而不改变B.因为在每次事务之后检查一致性，所以在事务开始之前已知A + B = 100。如果事务成功从A中删除10，则将实现原子性。但是，验证检查将显示A + B = 90，这与数据库的规则不一致。必须取消整个事务，并且受影响的行将回滚到其事务前状态。如果有其他限制，触发器或级联，在提交事务之前，将以与上述相同的方式检查每个单独的更改操作。其他约束也可能出现类似问题。我们可能要求A，B的数据类型都是整数。如果我们然后输入A的值13.5，则交易将被取消，或者系统可能以触发的形式发出警报（如果/当触发器被写入此效果时）。另一个例子是完整性约束，它不允许我们删除一个表中的行，其主键由至少一个引用 或者系统可能以触发器的形式发出警报（如果/当触发器被写入此效果时）。另一个例子是完整性约束，它不允许我们删除一个表中的行，其主键由至少一个引用 或者系统可能以触发器的形式发出警报（如果/当触发器被写入此效果时）。另一个例子是完整性约束，它不允许我们删除一个表中的行，其主键由至少一个引用其他表中的外键。 
