@echo off

set SEL_HOME="C:\Parasoft-packages\parasoft_selenic_2024.1.0"
set SEL_AGENT= "C:\Parasoft-packages\parasoft_selenic_2024.1.0\selenic_agent.jar"

set COV_DIR="cov_dir"
set COV_XML="%COV_DIR%\coverage.xml"

set V1_WAR="C:\Users\gtrofimov\Downloads\parabank-3.0.0-SNAPSHOT.war"
set V1_COV_URL="http://18.237.141.161:8050"

set V2_WAR="C:\Users\gtrofimov\Downloads\parabank-3.0.0-selenium-demo-SNAPSHOT.war"
set V2_APP_URL="http://18.237.141.161:8091"

call mvn test -DargLine=-javaagent:%SEL_AGENT%=collectCoverage=true,coverageAgentURL=%V1_COV_URL%,coverageDir=%COV_DIR%


call java -jar /home/selenic/coverage/Java/jtestcov/jtestcov.jar coverage \
    -selenic \
    -app %V1_WAR% \
    -runtime %COV_DIR% \
    -report %REPORT% \
    -include com\parasoft\parabank/** \
    -settings %SEL_HOME%\selenic.properties

call mvn com.parasoft:selenic-maven-plugin:impacted-tests test -Dselenic.coverage.binaries=%V2_WAR% -Dselenic.coverage.baseline=%COV_XML% -Dselenic.home=%SEL_HOME% -DPARABANK_BASE_URL=%V2_APP_URL%