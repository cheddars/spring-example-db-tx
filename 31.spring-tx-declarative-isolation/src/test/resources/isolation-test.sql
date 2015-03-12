-- Transaction #01
SELECT * FROM article WHERE title = 'transaction test';

DELETE FROM article WHERE title = 'transaction test';
COMMIT;

-- SET TRANSACTION transaction_mode [, ...]
-- SET SESSION CHARACTERISTICS AS TRANSACTION transaction_mode [, ...]

-- where transaction_mode is one of:

--    ISOLATION LEVEL { SERIALIZABLE | REPEATABLE READ | READ COMMITTED | READ UNCOMMITTED }
--    READ WRITE | READ ONLY
--    [ NOT ] DEFERRABLE
BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE;
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;

BEGIN TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
INSERT INTO article (
	board_seq, title, content, user_seq, reg_dt
) values (
	1, 'transaction test', 'transaction test content', 1, now()
);
COMMIT;



-- Transaction #02

SELECT * FROM article;



BEGIN;
	INSERT INTO article (board_seq, title, content, user_seq, reg_dt) values (1, 'transaction test', 'transaction test content', 1, now());
	SELECT current_setting('transaction_isolation');
COMMIT;