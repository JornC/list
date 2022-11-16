log=$(pwd)/conf/logback.xml

cd ..
echo "Starting in:"
pwd
mvn gwt:codeserver -pl :yogh-list-client -am -Dlogback.configurationFile=$log
