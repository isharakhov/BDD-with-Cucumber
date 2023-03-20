package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов Google страницы
 */
@Config.Sources({"classpath:avito_tests_config.properties"})
public interface AvitoTestConfig extends Config {

    /**
     * Метод возвращает параметр linkAttribute из avito_tests_config.properties
     *
     * @return параметр атрибута ссылки
     */
    String linkAttribute();

    /**
     * Метод возвращает параметр seleniumInput из avito_tests_config.properties
     *
     * @return параметр строки поиска
     */
    String inputSearchCity();

    /**
     * Метод возвращает параметр seleniumInput из avito_tests_config.properties
     *
     * @return параметр строки поиска
     */
    String inputSearchItem();
}