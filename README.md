# Spring Framework 5 OpenID Connect Client Example

Пример **OpenID Connect** клиента реализованного на добавленной в `Spring 5` поддержке
протокола в `Spring Security`.

Отличительная особеность демонстрации в отсутствии `Spring Boot` технологии.

### Ключевой стек технологий

* `Jdk 1.8`
* `Maven 3.3.9`
* `Spring Framework 5.0.1`
* `Spring Security OAuth Support 2.2.1`

### Развёртывание

1. Выставьте параметры сервера авторизации по `OpenID Connect` протоколу `application.properties#openIdConnect.*`.
    Например, `Google+` - https://console.developers.google.com.

1. Соберите командой `mvn clean install`.

1. Разверните `oidc-client.war` на одном из контейнеров сервлетов (например, `Tomcat 7`).

### Демонстрация

Откройте браузер на развёрнутом адресе. Следуйте предложенным инструкциям.