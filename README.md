Thymeleaf - Joda module
=======================
______

### ⚠ Deprecation notice
This project in no longer being maintained. Through with `thymeleaf-extras-java8time`, Thymeleaf provides support for JSR-310 date/time classes, so you might want to use those instead.

______

Inspired by [Thymeleaf Spring Security 3 integration module](https://github.com/thymeleaf/thymeleaf-extras-springsecurity3)

Features
========

This module provides a new dialect called `nl.eveoh.thymeleaf.joda.dialect.JodaDialect`,
with default prefix `joda`. It includes:

* New expression utility objects:
    * `#joda`: a expression utility object with methods for creating, comparing and formatting Joda time. See 
    `nl.eveoh.thymeleaf.joda.expression.Joda` for all implemented methods. 
    
Usage
=====

```xml
<bean id="templateEngine" class="org.thymeleaf.spring4.SpringTemplateEngine">
    <property name="templateResolver" ref="templateResolver"/>
    <property name="additionalDialects">
        <set>
            <bean class="nl.eveoh.thymeleaf.joda.dialect.JodaDialect"/>
        </set>
    </property>
</bean>
```

Using the expression utility objects
====================================

The `#joda` object can be easily used, like this:

```html
<span th:text="${#joda.format(activity.startTime, 'HH:mm')}">10:00</span>
```

Source code
===========

Source is available at [GitHub](https://github.com/eveoh/thymeleaf-joda)
