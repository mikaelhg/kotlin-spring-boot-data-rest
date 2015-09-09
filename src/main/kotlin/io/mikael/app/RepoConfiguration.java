package io.mikael.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Unfortunately we have to create this configuration this was, since Kotlin and CGLIB
 * don't seem to play well together in Spring.
 */
@Configuration
public class RepoConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureConversionService(final ConfigurableConversionService conversionService) {
        super.configureConversionService(conversionService);
        conversionService.addConverter(new GenericKeyConverter());
    }
}
