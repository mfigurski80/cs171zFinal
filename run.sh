#!/usr/bin/env bash
# java YourProgram Origin Destination < MapData.txt > temp.txt; cat MapData.txt temp.txt | java -jar DrawRoute.jar -b usa.jpg

javac PathFind.java
java PathFind Atlanta Reno < MapData.txt > temp.txt

java -jar DrawRoute.jar -b usa.jpg < MapData.txt

# wait till user presses 'enter'
read end