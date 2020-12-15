package com.wangong.goods_web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "wear.upload")
@Component
public class UploadPeoperies {

    private String baseUrl;
    private List<String> allowTypes;

}
