cd live
del /f src\%1.class
echo empty > ../output.txt

javac -d . src/%1.java 2> ../%2
java -classpath . src.%1 >> ../%2
