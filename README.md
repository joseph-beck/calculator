# CS2800 Calculator App

## Requirements

- Maven
- Javafx
- Make (optional)

## Usage

### Make

To compile a JAR use:

```sh
$ make build
```

To compile a JAR and run it use:

```sh
$ make
```

To run it as a Javafx app with maven use:

```sh
$ make javafx
```

To test use:

```sh
$ make test
```

### Maven

To compile a JAR use:

```sh
$ mvn package compile test
```

To compile a JAR and run it use:

```sh
$ mvn package compile test
$ java -jar target/<jar>.jar
```

To run it as a Javafx app with maven use:

```sh
$ mvn package clean compile test javafx:run
```

To test use:

```sh
$ make clean test
```
