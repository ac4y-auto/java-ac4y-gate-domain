# java-ac4y-gate-domain

Gate domain module - user entity with algebra pattern for authentication.

## Maven Dependency

```xml
<dependency>
    <groupId>ac4y</groupId>
    <artifactId>ac4y-gate-domain</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Overview

Provides the `Ac4yUser` domain entity for the Ac4y authentication system. Uses the algebra-domain pattern where `Ac4yUserAlgebra` defines fields (user, password) and `Ac4yUser` is the concrete domain class.

**No external ac4y dependencies** - this is a standalone module.

## Package Structure

- `ac4y.gate.algebra` - Ac4yUserAlgebra (user, password fields)
- `ac4y.gate.domain` - Ac4yUser domain class

## Usage

```java
Ac4yUser user = new Ac4yUser();
user.setUser("admin");
user.setPassword("secret");
```

## Build

```bash
mvn clean install
mvn test
```

## Origin

Extracted from `IJAc4yGateModule/IJAc4yGateDomain` module.

---
**Version:** 1.0.0
