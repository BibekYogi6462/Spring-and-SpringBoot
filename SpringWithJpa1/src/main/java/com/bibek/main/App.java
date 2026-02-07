package com.bibek.main;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DriverManagerDataSource obj1 = new DriverManagerDataSource();
        obj1.setDriverClassName(null);
        obj1.setUrl(null);
        obj1.setUsername(null);
        obj1.setPassword(null);
        
        
      LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
      lcemfb.setDataSource(obj1);
      lcemfb.setPackagesToScan(args);
      
      
      
      HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
      
      
    }
}
