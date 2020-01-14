package com.idianyou.media.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("media.master.datasource")
public class MasterDatabaseProperties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

    private long connectionTimeout;

    private int maxPoolSize;

    private long idleTimeout;

    private int minIdle;

    private String poolName;

    @Override
    public String toString() {
        return "MasterDatabaseProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", maxPoolSize=" + maxPoolSize +
                ", idleTimeout=" + idleTimeout +
                ", minIdle=" + minIdle +
                ", poolName='" + poolName + '\'' +
                '}';
    }
}
