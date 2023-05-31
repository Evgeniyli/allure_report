set SELENIUM_SERVER=C:\Users\ylyzohubov\Downloads\testframework\src\main\resources\grid\server\selenium-server-standalone-3.9.1.jar
set HUB_ADDRESS= http://localhost:4444/grid/register/
set NODE_CONFIG=C:\Users\ylyzohubov\Downloads\testframework\src\main\resources\grid\configurations/node3-config.json
set CHROME_DRIVER=C:\Users\ylyzohubov\Downloads\testframework\src\main\resources\grid\drivers\chromedriver.exe
set FIREFOX_DRIVER=C:\Users\ylyzohubov\Downloads\testframework\src\main\resources\grid\drivers\geckodriver.exe
set IE_DRIVER=DC:\Users\ylyzohubov\Downloads\testframework\src\main\resources\grid\drivers\IEDriverServer.exe


cd  C:\Users\ylyzohubov\Downloads\testframework\src\main\resources\grid\drivers
java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -Dwebdriver.internetexplorer.driver=%IE_DRIVER% -Dwebdriver.gecko.driver=%FIREFOX_DRIVER% -jar %SELENIUM_SERVER% -role node -hub %HUB_ADDRESS% -nodeConfig %NODE_CONFIG%


