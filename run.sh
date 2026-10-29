#!/bin/sh
set -eu
cd "$(dirname "$0")"
mkdir -p out
java -m jdk.compiler/com.sun.tools.javac.Main -encoding UTF-8 -d out src/*.java
java -cp out Main
