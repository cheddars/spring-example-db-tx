## Transaction Isolation

### 1. ISOLATION LEVEL ###

#### 1.1. ISOLATION\_DEFAULT ####

하부 데이터 저장소의 기본 격리수준을 이용한다. 이는 데이터 저장소마다 다르다

#### 1.2. ISOLATION\_READ\_UNCOMMITTED ####
 
커밋되지 않은 데이터 변경사항을 읽을 수 있다. 쓰레기 읽기, 재생 불가능한 읽기, 허상읽기를 허용한다

#### 1.3. ISOLATION\_READ\_COMMITTED ####

다른 트랜잭션이 커밋된 변경사항만 읽을 수 있도록 한다. 따라서 쓰레기 읽기는 방지되지만, 재생 불가능한 읽기나 허상 읽기는 여전히 발생한다.

                                    
#### 1.4. ISOLATION\_REAPEATABLE\_READ ####

같은 데이터 필드는 여러 번 반복해서 읽더라도 동일한 값을 읽도록 한다. 물론 자신이 변경한 필드는 변경된 값을 읽데 된다. 따라서 쓰레기 읽기와 재생 불가능한 읽기는 방지되지만, 허상 읽기는 여전히 발생한다.

#### 1.5. ISOLATION\_SERIALIZABLE ####

완전한 ACID를 보장하는 격리수준으로 모든 문제점이 방지된다. 그러나 보통 해당 트랜잭션에 관련된 모든 테이블에 잠금을 걸어 버르게 되므로, 가장 성능 비효율적인 격리수준이다.

### 2. Read phenomena ###

#### 2.1. DIRTY\_READ ####

A dirty read (aka uncommitted dependency) occurs when a transaction is allowed to read data from a row that has been modified by another running transaction and not yet committed.

![image](http://thumbnail.egloos.net/600x0/http://pds21.egloos.com/pds/201409/18/82/b0015882_541a553932769.png)


#### 2.2. NONREPEATABLE\_READ ####

A non-repeatable read occurs, when during the course of a transaction, a row is retrieved twice and the values within the row differ between reads.

![image](http://thumbnail.egloos.net/600x0/http://pds21.egloos.com/pds/201409/18/82/b0015882_541a553f33198.png)


#### 2.3. PHANTOM\_READ ####

A phantom read occurs when, in the course of a transaction, two identical queries are executed, and the collection of rows returned by the second query is different from the first.

![image](http://thumbnail.egloos.net/600x0/http://pds21.egloos.com/pds/201409/18/82/b0015882_541a55450c7dd.png)

#### 2.4. Summary ####

![image](http://thumbnail.egloos.net/600x0/http://pds25.egloos.com/pds/201409/18/82/b0015882_541a4a583d3c1.png)


[PostgreSQL - Transaction](http://www.postgresql.org/docs/9.1/static/transaction-iso.html "postgreSQL - Transaction")

In PostgreSQL, you can request any of the four standard transaction isolation levels. **But internally, there are only three distinct isolation levels, which correspond to the levels Read Committed, Repeatable Read, and Serializable**. When you select the level **Read Uncommitted you really get Read Committed**, and phantom reads are not possible in the PostgreSQL implementation of Repeatable Read, so the actual isolation level might be stricter than what you select. This is permitted by the SQL standard: the four isolation levels only define which phenomena must not happen, they do not define which phenomena must happen. The reason that PostgreSQL only provides three isolation levels is that this is the only sensible way to map the standard isolation levels to the multiversion concurrency control architecture. The behavior of the available isolation levels is detailed in the following subsections.