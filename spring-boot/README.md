# Spring Boot

## Gradle configuration

build.gradle
```groovy
plugins {
  id 'java'
  id 'org.springframework.boot' version '3.2.2'
}

apply plugin: 'io.spring.dependency-management'

repositories {
  mavenCentral()
}

dependencies {
  implementation 'org.springframework.boot:spring-boot-starter'
}
```

## Common application properties

- https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

