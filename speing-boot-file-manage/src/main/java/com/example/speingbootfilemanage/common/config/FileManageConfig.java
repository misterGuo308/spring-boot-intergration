package com.example.speingbootfilemanage.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoyou
 * @date 2020/1/15 21:53
 */
@Configuration
@ConfigurationProperties(prefix = "http.file")
@Data
public class FileManageConfig {

    private Upload upload = new Upload();

    private Download download = new Download();

    @Data
    public static class Upload {
        private String url;
    }


    @Data
    public static class Download {
        private String path;
    }
}
