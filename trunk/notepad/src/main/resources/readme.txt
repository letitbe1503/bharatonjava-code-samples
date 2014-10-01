In your tomcat's context.xml file put following line between <Context> and </Context>. This defines your connection pool. 
	
	
	<Resource name="jdbc/notepad" auth="Container" type="javax.sql.DataSource"
		maxActive="50" maxIdle="30" maxWait="10000" username="root" password="root"
		driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/notepad" />

		
		
put below xml snippet in web.xml


	<resource-ref>
		<description>DB Connection</description>
		<res-ref-name>jdbc/notepad</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>






################################################################

<Resource name="jdbc/notepad"
          auth="Container"
          type="javax.sql.DataSource"
          factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
          testWhileIdle="true"
          testOnBorrow="true"
          testOnReturn="false"
          validationQuery="SELECT 1"
          validationInterval="30000"
          timeBetweenEvictionRunsMillis="30000"
          maxActive="100"
          minIdle="10"
          maxWait="10000"
          initialSize="10"
          removeAbandonedTimeout="60"
          removeAbandoned="true"
          logAbandoned="true"
          minEvictableIdleTimeMillis="30000"
          jmxEnabled="true"
          jdbcInterceptors="org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;
            org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer"
          username="root"
          password="root"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/notepad"/>