package cn.zcc1907;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;

import cn.zcc1907.util.SpringBootVFS;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "cn.zcc1907.dao")
public class DatabaseConfiguration implements EnvironmentAware  { 
	
    private Environment environment; 
    private RelaxedPropertyResolver propertyResolver; 
    
    @Override 
    public void setEnvironment(Environment environment) { 
      this.environment = environment; 
      this.propertyResolver = new RelaxedPropertyResolver(environment,"spring.datasource."); 
    } 
    
    //注册dataSource 
    @Bean(initMethod = "init", destroyMethod = "close") 
    public DruidDataSource dataSource() throws SQLException { 
      if (StringUtils.isEmpty(propertyResolver.getProperty("url"))) { 
        System.out.println("Your database connection pool configuration is incorrect!" 
            + " Please check your Spring profile, current profiles are:"
            + Arrays.toString(environment.getActiveProfiles())); 
         throw new ApplicationContextException( 
            "Database connection pool is not configured correctly"); 
      } 
      DruidDataSource druidDataSource = new DruidDataSource(); 
      druidDataSource.setDriverClassName(propertyResolver.getProperty("driverclassname")); 
      druidDataSource.setUrl(propertyResolver.getProperty("url")); 
      druidDataSource.setUsername(propertyResolver.getProperty("username")); 
      druidDataSource.setPassword(propertyResolver.getProperty("password")); 
      druidDataSource.setInitialSize(Integer.parseInt(propertyResolver.getProperty("initialSize"))); 
      druidDataSource.setMinIdle(Integer.parseInt(propertyResolver.getProperty("minIdle"))); 
      druidDataSource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("maxActive"))); 
      druidDataSource.setMaxWait(Integer.parseInt(propertyResolver.getProperty("maxWait"))); 
      druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(propertyResolver.getProperty("timeBetweenEvictionRunsMillis"))); 
      druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(propertyResolver.getProperty("minEvictableIdleTimeMillis"))); 
      druidDataSource.setValidationQuery(propertyResolver.getProperty("validationQuery")); 
      druidDataSource.setTestWhileIdle(Boolean.parseBoolean(propertyResolver.getProperty("testWhileIdle"))); 
      druidDataSource.setTestOnBorrow(Boolean.parseBoolean(propertyResolver.getProperty("testOnBorrow"))); 
      druidDataSource.setTestOnReturn(Boolean.parseBoolean(propertyResolver.getProperty("testOnReturn"))); 
      druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(propertyResolver.getProperty("poolPreparedStatements"))); 
      druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(propertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize"))); 
      druidDataSource.setFilters(propertyResolver.getProperty("filters")); 
      return druidDataSource; 
    } 
    

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception { 
      /**
       * 重写VFS类，解决打包成jar后不能扫描bean的问题
       */
      VFS.addImplClass(SpringBootVFS.class);
      
      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean(); 
      sqlSessionFactory.setDataSource(dataSource());
      //mybatis分页 
      PageHelper pageHelper = new PageHelper();
      Properties props = new Properties(); 
      props.setProperty("dialect", "mysql"); 
      props.setProperty("reasonable", "true"); 
      props.setProperty("pageSizeZero", "true"); 
      props.setProperty("supportMethodsArguments", "true"); 
      props.setProperty("returnPageInfo", "check"); 
      props.setProperty("params", "count=countSql"); 
      pageHelper.setProperties(props); //添加插件 
      sqlSessionFactory.setPlugins(new Interceptor[]{pageHelper}); 
      PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(); 
      sqlSessionFactory.setTypeAliasesPackage("cn.zcc1907.bean");
      sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/cn/zcc1907/mapper/*.xml")); 
      return sqlSessionFactory.getObject(); 
    }

    
    @Bean 
    public PlatformTransactionManager transactionManager() throws SQLException { 
      return new DataSourceTransactionManager(dataSource()); 
    }

}