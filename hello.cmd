cd live
del /f src\*.class
echo empty > ../output.txt

javac -d . src/%1.java 2> ../output.txt
java -classpath . src.%1 >> ../output.txt
