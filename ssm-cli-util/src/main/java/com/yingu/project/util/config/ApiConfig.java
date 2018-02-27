package com.yingu.project.util.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by MMM on 2017/08/30.
 * api接口配置
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "api-config")
public class ApiConfig {
    public String nonebank_url;
    public String nonebank_access_key;
    public String nonebank_secret_key;


}
