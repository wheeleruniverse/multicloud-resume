package com.wheeler.core.config;

import com.wheeler.core.utility.ReflectUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig;

    @BeforeEach
    public void beforeEach(){
        this.swaggerConfig = new SwaggerConfig();
    }

    @Test
    public void annotationConditionalOnProperty(){
        final ConditionalOnProperty annotation = ReflectUtil.getAnnotation(ConditionalOnProperty.class, swaggerConfig);
        assertEquals("true", annotation.havingValue());
        assertEquals("com.wheeler.core.module.swagger.enabled", annotation.value()[0]);
    }

    @Test
    public void annotationConfiguration(){
        assertNotNull(ReflectUtil.getAnnotation(Configuration.class, swaggerConfig));
    }

    @Test
    public void annotationEnableSwagger2(){
        assertNotNull(ReflectUtil.getAnnotation(EnableSwagger2.class, swaggerConfig));
    }

    @Test
    public void docket(){
        final Docket docket = swaggerConfig.docket();
        assertNotNull(docket);
    }
}
