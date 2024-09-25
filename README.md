# WiemanApi

A simple API used to manage information about me in a centralized placed.

## Getting Started

This project is made with Spring Boot please refer to the [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) for more information.

## Design

### Layer architecture

```mermaid
classDiagram
    controller --> dto
    controller --> exceptionHandler
    controller --> service
    service --> model
    service --> repository
    model --> exception
    service --> exception

    namespace presentation {
        class controller
        class dto
        class exceptionHandler
    }

    namespace application {
        class service
    }

    namespace domain {
        class model
        class exception
    }

    namespace data {
        class repository
    }


```

### Domain

```mermaid
classDiagram
    Profile "1" --> "*" Description: descriptions
    Profile "1" --> "*" SkillSection: skillSections
    Profile "1" --> "*" Social: socials
    SkillSection "1" --> "*" Skill: skills
    
    
    class Profile {
        - firstName: String
        - lastName: String
        - username: String
    }
    class Description{
        - locale: String
        - title: String
        - content: String
    }
    class SkillSection {
        - locale: String
        - title: String
    }
    class Skill {
        - name: String
        - level: int
    }
    class Social {
        - name: String
        - platform: String
        - url: String
    }
```