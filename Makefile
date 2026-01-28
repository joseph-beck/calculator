TARGET_PATH := target
JAR := cw2-0.0.1-SNAPSHOT-jar-with-dependencies.jar

all: build
	java -jar $(TARGET_PATH)/$(JAR)

javafx:
	mvn package clean compile test javafx:run

build:
	mvn package compile test

test:
	mvn clean test

.phony:
	all javafx build test

