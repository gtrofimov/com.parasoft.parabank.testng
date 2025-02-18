SET DTP_PROJECT=Parabank Demo
SET REPORT_DIR=%CD%\target\jtest-reports\Test1
SET LOG_DIR=%CD%\target\logs
SET BUILD_ID=1
mkdir %CD%\target
mkdir %REPORT_DIR%
mkdir %LOG_DIR%

call mvn clean
call mvn install jtest:jtest -Djtest.config="CWE Top 25 2020.properties" -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true -Dproperty.dtp.project=%DTP_PROJECT% -Djtest.showsettings=true -Djtest.report=%REPORT_DIR%\jtest-cwe-top25 -Dproperty.console.verbosity.level=high -Dproperty.build.id=%BUILD_ID% -Djacoco.skip=true > %LOG_DIR%\jtest-cwe-top25-%BUILD_ID%.log 2>&1