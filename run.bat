@echo off
cd /d "%~dp0"
if not exist out mkdir out
java -m jdk.compiler/com.sun.tools.javac.Main -encoding UTF-8 -d out src\*.java
if errorlevel 1 exit /b 1
java -cp out Main
