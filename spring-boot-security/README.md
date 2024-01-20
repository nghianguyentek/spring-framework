# Spring Boot Security

## Gradle configuration

build.gradle
```groovy
dependencies {
	implementation "org.springframework.boot:spring-boot-starter-security"
}
```

### Specific version

build.gradle
```groovy
ext['spring-security.version']='6.2.1'
ext['spring.version']='6.1.2'
```

## Features

- [Authentication](document/features/authentication.md): dealing with "who you are" problem
- [Authorization](document/features/authorization.md): dealing with "what you allow to do" problem

## References

- https://docs.spring.io/spring-security/reference/index.html