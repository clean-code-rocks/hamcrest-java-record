# Hamcrest - Record

[![Maven Central](https://img.shields.io/maven-central/v/rocks.cleancode/hamcrest-record?color=brightgreen)](https://search.maven.org/artifact/rocks.cleancode/hamcrest-record)
[![codecov](https://codecov.io/gh/clean-code-rocks/hamcrest-java-record/branch/main/graph/badge.svg?token=XYLSYOAAP3)](https://codecov.io/gh/clean-code-rocks/hamcrest-java-record)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fclean-code-rocks%2Fhamcrest-java-record.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fclean-code-rocks%2Fhamcrest-java-record?ref=badge_shield)

[Java Hamcrest](http://hamcrest.org/JavaHamcrest/) matchers for record.

## Installation

### Maven

```xml
<dependency>
    <groupId>rocks.cleancode</groupId>
    <artifactId>hamcrest-record</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>
```

## Requirement

Java 16 or higher.

## Usage

Two matchers are provided for record: `hasField(fieldName)` and `field(fieldName, matcher)`.

### hasField(fieldName)

This matcher matches existing field with not null value.

```java
import static org.hamcrest.MatcherAssert.assertThat;
import static rocks.cleancode.hamcrest.record.HasFieldMatcher.hasField;

Person person = new Person("John", "DOE");

assertThat(person, hasField("firstName"));
```

### field(fieldName, matcher)

This matcher matches the value of the field.

```java
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static rocks.cleancode.hamcrest.record.HasFieldMatcher.field;

Person person = new Person("John", "DOE");

assertThat(person, field("firstName", is(equalTo("John"))));
```
