SELECT
    trx_id,
    trx_weight AS '权重(修改和锁住的行数)',
    trx_requested_lock_id AS '等待事务的锁ID',
    trx_wait_started AS '事务等待开始的时间'
FROM
    information_schema.INNODB_TRX;



select * from information_schema.INNODB_LOCKS;

select * from information_schema.INNODB_LOCK_WAITS;
					