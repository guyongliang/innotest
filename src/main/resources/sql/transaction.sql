SELECT
    trx_id,
    trx_weight AS '权重(修改和锁住的行数)',
    TRX_STATE AS '事务执行状态',
    TRX_STARTED as '交易开始时间',
    TRX_TABLES_IN_USE as '处理此事务的当前SQL语句时使用 的表数',
    TRX_TABLES_LOCKED as '当前SQL语句具有行锁定 的表的数量',
    TRX_LOCK_STRUCTS as '事务保留的锁数',
    TRX_ISOLATION_LEVEL as '隔离级别',
    trx_requested_lock_id AS '等待事务的锁ID',
    trx_wait_started AS '事务等待开始的时间',
    TRX_ROWS_LOCKED as '此交易锁定的大致数字或行数',
    TRX_ROWS_MODIFIED AS '此事务中已修改和插入的行数'
FROM
    information_schema.INNODB_TRX;




select * from information_schema.INNODB_LOCKS;

select * from information_schema.INNODB_LOCK_WAITS;