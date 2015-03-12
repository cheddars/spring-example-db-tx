## @Transaction properties ##

#### 1. value ####
 
type : String

desc : Optional qualifier specifying the transaction manager to be used.

	<tx:annotation-driven transaction-manager="transactionManager" />
	
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="datasource" />
		<qualifier value="statistics" />
	</bean>

	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="datasource" />
		<qualifier value="general" />
	</bean>
	
---

	@Transactional(propagation=Propagation.REQUIRES_NEW, value="statistics")
	

#### 2. propagation ####

type : enum: Propagation

desc : Optional propagation setting.

	@Transactional(propagation=Propagation.REQUIRES_NEW)
                                    
#### 3. isolation ####

type : enum: Isolation

desc : Optional isolation level.

	@Transactional(isolation=Isolation.REPEATABLE_READ)

#### 4. readOnly ####

type : boolean

desc : Read/write vs. read-only transaction

	@Transactional(readOnly=true)

#### 5. timeout ####

type : int (in seconds granularity)

desc : Transaction timeout.

	@Transactional(timeout=10)

#### 6. rollbackFor ####

type : Array of Class objects, which must be derived from Throwable.

desc : Optional array of exception classes that must cause rollback.

	@Transactional(rollbackFor={SQLException.class, RuntimeException.class})

---

		/**
	 * Defines zero (0) or more exception {@link Class classes}, which must be a
	 * subclass of {@link Throwable}, indicating which exception types must cause
	 * a transaction rollback.
	 * <p>This is the preferred way to construct a rollback rule, matching the
	 * exception class and subclasses.
	 * <p>Similar to {@link org.springframework.transaction.interceptor.RollbackRuleAttribute#RollbackRuleAttribute(Class clazz)}
	 */
	Class<? extends Throwable>[] rollbackFor() default {};


#### 7. rollbackForClassName ####

type : Array of class names. Classes must be derived from Throwable.

desc : Optional array of names of exception classes that must cause rollback.

	@Transactional(rollbackForClassName={"SQLException", "RuntimeException"})

---

		/**
	 * Defines zero (0) or more exception names (for exceptions which must be a
	 * subclass of {@link Throwable}), indicating which exception types must cause
	 * a transaction rollback.
	 * <p>This can be a substring, with no wildcard support at present.
	 * A value of "ServletException" would match
	 * {@link javax.servlet.ServletException} and subclasses, for example.
	 * <p><b>NB: </b>Consider carefully how specific the pattern is, and whether
	 * to include package information (which isn't mandatory). For example,
	 * "Exception" will match nearly anything, and will probably hide other rules.
	 * "java.lang.Exception" would be correct if "Exception" was meant to define
	 * a rule for all checked exceptions. With more unusual {@link Exception}
	 * names such as "BaseBusinessException" there is no need to use a FQN.
	 * <p>Similar to {@link org.springframework.transaction.interceptor.RollbackRuleAttribute#RollbackRuleAttribute(String exceptionName)}
	 */
	String[] rollbackForClassName() default {};


#### 8. noRollbackFor ####

type : Array of Class objects, which must be derived from Throwable.

desc : Optional array of exception classes that must not cause rollback.

#### 9. noRollbackForClassName ####

type : Array of String class names, which must be derived from Throwable.

desc : Optional array of names of exception classes that must not cause rollback.

