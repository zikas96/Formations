mvn clean install
#cd target
#mkdir dependency
#cd dependency
#jar -xf ../*.jar
#cd ..
#cd ..
#echo "zikassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
#docker login
docker build -t zikas1996/lo54:0.0.1 .
docker run -d -p 8056:8080 zikas1996/lo54:0.0.1
