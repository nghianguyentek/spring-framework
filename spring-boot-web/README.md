# Spring Boot Web

## Gradle dependencies

build.gradle
```groovy
implementation('org.springframework.boot:spring-boot-starter-web') {
    exclude group: 'org.springframework.boot', module: 'spring-boot-starter-tomcat'
}
runtimeOnly 'org.springframework.boot:spring-boot-starter-jetty'
```

## Server properties

- [server](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.server)