核心服务
项目中采用bootstrap.yml和application.yml 配置文件bootstrap.yml配置文件优先于application/yml加载.对于项目的通用的配置在这里定义,项目单独的服务在application.yml在定义

datasource.primary.url=jdbc:mysql://localhost:3306/shiro
datasource.primary.username=root
datasource.primary.password=root
datasource.primary.type=com.alibaba.druid.pool.DruidDataSource
datasource.primary.driver-class-name= com.mysql.jdbc.Driver
datasource.primary.filters= mergeStat
datasource.primary.maxActive= 20
datasource.primary.initialSize= 1
datasource.primary.maxWait= 60000
datasource.primary.minIdle= 1
datasource.primary.timeBetweenEvictionRunsMillis= 60000
datasource.primary.minEvictableIdleTimeMillis= 300000
datasource.primary.validationQuery select 1
datasource.primary.testWhileIdle= false
datasource.primary.testOnBorrow= false
datasource.primary.testOnReturn= false
datasource.primary.poolPreparedStatements= false
datasource.primary.maxOpenPreparedStatements= false


datasource.secondary.url=jdbc:mysql://localhost:3306/shiro
datasource.secondary.username=root
datasource.secondary.password=root
datasource.secondary.type=com.alibaba.druid.pool.DruidDataSource
datasource.secondary.driver-class-name= com.mysql.jdbc.Driver
datasource.primary.filters= mergeStat
datasource.primary.maxActive= 20
datasource.primary.initialSize= 1
datasource.primary.maxWait= 60000
datasource.primary.minIdle= 1
datasource.primary.timeBetweenEvictionRunsMillis= 60000
datasource.primary.minEvictableIdleTimeMillis= 300000
datasource.primary.validationQuery select 1
datasource.primary.testWhileIdle= false
datasource.primary.testOnBorrow= false
datasource.primary.testOnReturn= false
datasource.primary.poolPreparedStatements= false
datasource.primary.maxOpenPreparedStatements= false