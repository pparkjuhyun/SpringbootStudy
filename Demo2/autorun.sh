# shellcheck disable=SC2211

echo start packaging springboot...
./mvnw clean package

echo
echo start application...
java -jar ./target/*SNAPSHOT.jar
