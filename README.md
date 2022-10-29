# Hamcrest - Record

[![Maven Central][Maven Central - badge]][Maven Central - link]
[![Javadoc][Javadoc - badge]][Javadoc - link]
[![Codecov][Codecov - badge]][Codecov - link]
[![License: GPL v3][Licence - badge]][Licence - link]
[![Fossa][Fossa - badge]][Fossa - link]

[Java Hamcrest] matchers for record.

## Requirement

Java 16+

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

[Java Hamcrest]: https://hamcrest.org/JavaHamcrest/

[Maven Central - badge]: https://img.shields.io/maven-central/v/rocks.cleancode/hamcrest-record?color=brightgreen
[Maven Central - link]: https://search.maven.org/artifact/rocks.cleancode/hamcrest-record
[Javadoc - badge]: https://javadoc.io/badge2/rocks.cleancode/hamcrest-record/javadoc.svg
[Javadoc - link]: https://javadoc.io/doc/rocks.cleancode/hamcrest-record
[Codecov - badge]: https://codecov.io/gh/clean-code-rocks/hamcrest-java-record/branch/main/graph/badge.svg?token=XYLSYOAAP3
[Codecov - link]: https://codecov.io/gh/clean-code-rocks/hamcrest-java-record
[Licence - badge]: https://img.shields.io/badge/License-GPLv3-blue.svg
[Licence - link]: https://www.gnu.org/licenses/gpl-3.0
[Fossa - badge]: https://app.fossa.com/api/projects/git%2Bgithub.com%2Fclean-code-rocks%2Fhamcrest-java-record.svg?type=shield
[Fossa - link]: https://app.fossa.com/projects/git%2Bgithub.com%2Fclean-code-rocks%2Fhamcrest-java-record?ref=badge_shield
