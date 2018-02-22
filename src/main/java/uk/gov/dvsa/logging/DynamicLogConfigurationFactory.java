package uk.gov.dvsa.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.net.URI;

@Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(50)
public class DynamicLogConfigurationFactory extends ConfigurationFactory {

    private static final String LOG_LEVEL_ENV_VARIABLE = "CERT_LOG_LEVEL";
    private static final Level DEFAULT_LEVEL = Level.INFO;
    private static final String APPENDER_NAME = "LAMBDA";
    private static final String AWS_LAMBDA_LOG4J2_PLUGIN = "Lambda";
    private static final String JSON_LAYOUT_PLUGIN = "JSONLayout";

    @Override
    protected String[] getSupportedTypes() {
        return new String[] {"*"};
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final ConfigurationSource source) {
        return getConfiguration(loggerContext, source.toString(), null);
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final String name, final URI configLocation) {
        ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
        return createConfiguration(name, builder);
    }

    private static Configuration createConfiguration(final String name, ConfigurationBuilder<BuiltConfiguration> builder) {
        builder.setConfigurationName(name);
        builder.setStatusLevel(Level.ERROR);

        AppenderComponentBuilder appenderBuilder = builder.newAppender(APPENDER_NAME, AWS_LAMBDA_LOG4J2_PLUGIN);
        appenderBuilder.add(
            builder.newLayout(JSON_LAYOUT_PLUGIN)
                .addAttribute("complete", false)
                .addAttribute("compact", true)
                .addAttribute("properties", true)
        );
        builder.add(appenderBuilder);

        builder.add(
            builder.newRootLogger(readLevel())
                .add(builder.newAppenderRef(APPENDER_NAME))
        );
        return builder.build();
    }

    private static Level readLevel() {
        String levelName = System.getenv(LOG_LEVEL_ENV_VARIABLE);
        return Level.toLevel(levelName, DEFAULT_LEVEL);
    }
}
