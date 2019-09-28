set projectLocation=C:\Automation\automation_java_projects\Full_Stack_Test_Atomation_Project
cd%projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\Drivers\libs\*
java org.testng.TestNG %projectLocation%\SuiteExecution.xml
pause
