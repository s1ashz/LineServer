#!/bin/bash
SYSTEMURL=${1:-}
if [[ -z "$SYSTEMURL" ]]; 
then
    echo "Please specify a file"
else 
echo "reading:" $SYSTEMURL"..."
java -jar target/lineserver-0.0.1-SNAPSHOT.jar --file.path="$SYSTEMURL"
fi
