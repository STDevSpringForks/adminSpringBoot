package com.fd.mvc.config.database;

import com.fd.mvc.model.entity.DomainPackagesJPA;
import com.fd.mvc.repository.RepositoryPackageMysql;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager",
        basePackageClasses = RepositoryPackageMysql.class
)
public class JPAMysqlConfig {

    private final DataSource datasourceMysql;

    public JPAMysqlConfig(DataSource datasourceMysql) {
        this.datasourceMysql = datasourceMysql;
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(datasourceMysql);
        emf.setPackagesToScan(DomainPackagesJPA.class.getPackageName());
        emf.setPersistenceUnitName("mysql");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // Optional but clean
        return emf;
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager() {
        return new JpaTransactionManager(mysqlEntityManagerFactory().getObject());
    }
}
