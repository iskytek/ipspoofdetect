#!/bin/sh

echo "Cleaning bin directory"

rm -r ./bin
mkdir bin

echo "Compiling files"

javac -d ./bin src/Main.java

echo "Executing entry point"

echo "Code output - "

java -classpath ./bin main.Main
