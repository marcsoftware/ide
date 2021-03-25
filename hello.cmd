cd live
del /f src\*.class
echo empty > ../output.txt

javac -d . src/*.java 2> ../output.txt
java -classpath . src.hardcoded >> ../output.txt
