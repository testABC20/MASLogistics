package com.mas.quotation.configuration;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBConfiguration {
  @Value("${spring.datasource.url}")
  private String url;
  
  @Value("${spring.datasource.username}")
  private String username;
  
  @Value("${spring.datasource.password}")
  private String password;
  
  @Value("${spring.datasource.driverClassName}")
  private String driverClassName;
  
  @Value("${spring.datasource.hikari.maximum-pool-size}")
  private int maximumPoolSize;
  
  @Value("${spring.datasource.hikari.connection-timeout}")
  private long connectionTimeout;
  
  @Value("${spring.datasource.hikari.pool-name}")
  private String poolName;
  
  @Value("${spring.datasource.hikari.minimumIdle}")
  private int minimumIdle;
  
  @Value("${spring.datasource.hikari.max-lifetime}")
  private long maxLifetime;
  
  @Value("${spring.datasource.hikari.idle-timeout}")
  private long idleTimeout;
  
  @Value("${spring.datasource.algorithm}")
  private String algorithm;
  
  @Value("${spring.datasource.word}")
  private String word;
  
  @Bean
  HikariDataSource getDataSource() {
    StandardPBEStringEncryptor strongEncrypt = new StandardPBEStringEncryptor();
    strongEncrypt.setAlgorithm(this.algorithm);
    strongEncrypt.setPassword(this.word);
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setDriverClassName(this.driverClassName);
    hikariConfig.setJdbcUrl(this.url);
    hikariConfig.setUsername(this.username);
    hikariConfig.setPassword(strongEncrypt.decrypt(this.password));
    hikariConfig.setMaximumPoolSize(this.maximumPoolSize);
    hikariConfig.setPoolName(this.poolName);
    hikariConfig.setConnectionTimeout(this.connectionTimeout);
    hikariConfig.setMinimumIdle(this.minimumIdle);
    hikariConfig.setMaxLifetime(this.maxLifetime);
    hikariConfig.setIdleTimeout(this.idleTimeout);
    hikariConfig.addDataSourceProperty("datasource.cachePrepStmts", "true");
    hikariConfig.addDataSourceProperty("datasource.prepStmtCacheSize", "250");
    hikariConfig.addDataSourceProperty("datasource.prepStmtCacheSqlLimit", "2048");
    hikariConfig.addDataSourceProperty("datasource.useServerPrepStmts", Boolean.TRUE);
    hikariConfig.addDataSourceProperty("useServerPrepStmts", Boolean.TRUE);
    return new HikariDataSource(hikariConfig);
  }
}
