rm bin/*/*
javac src/*/* -classpath ./bin:./lib/jcalendar-1.4.jar:./lib/mysql-connector-java-5.1.24-bin.jar:. -d bin/
echo "compilation terminée"
javadoc src/*/* -d doc/
echo "Javadoc créée"
