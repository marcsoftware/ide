del /f live\src\*.class
echo empty > output.txt

javac -d . live/src/*.java 2> output.txt
java -classpath . live.src.hardcoded >> output.txt
