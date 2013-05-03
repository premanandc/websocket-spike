Websocket server spike

To build server from sources:

Make sure you have play 2.1.1 installed:

cd server
play clean compile

To build client from sources:

cd client
mvn clean install

If you see errors, you may need to pull in other projects and install them in your local maven repo:

git clone https://github.com/tavendo/AutobahnAndroid.git autobahn
cd autobahn/AutoBahn
mvn clean install

git clone https://github.com/mosabua/maven-android-sdk-deployer.git
cd maven-andrdoid-sdk-deployer/platforms/android-17/
mvn clean install


To run the server:

play clean start

To run the client:

Install the apk onto a real device or emulator.
Connect to server. Enjoy
