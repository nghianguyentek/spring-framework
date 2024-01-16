# Spring Bean

- [`BeanFactory` interface](document/bean-factory.md)

## Dependency graph

```mermaid
classDiagram
    class spring-bean["org.springframework:spring-beans"]
    class spring-core["org.springframework:spring-core"]
    class spring-jcl["org.springframework:spring-jcl"]
    
    spring-core..>spring-jcl
    spring-bean..>spring-core
```