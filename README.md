# cis5210-module-8

Before starting the "quiz" please setup your software to run in NetBeans. Once things are up and running modify the code according to the questions in the quiz.

# Setup to run the example code:

#Java: 

* Install Amazon's Java Install from https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html
(if for some reason this isn't installed a newer version of the following code has been developed which works with the latest java.)

* You will need to add this version to the Platforms listed in NetBean's it it isn't automatically added. https://netbeans.apache.org/kb/docs/java/javase-embedded.html 

# Tomcat:

Download Apache Tomcat 9.x from https://tomcat.apache.org/download-90.cgi. 
Extract this to your home directory. (Makes sure to download the correct core version for your computer with a ZIP or TAR GZ file, do not install anything Windows Specific).
You may need to create a file in the extracted directory. bin/setenv.sh, this is only needed if Tomcat doesn't start in NetBeans.

In this file please add the line.

export JAVA_HOME="PATHTOWHEREYOUINSTALLED JAVA"

# NetBeans

* Download and Install Netbeans from https://netbeans.org 
* Start Netbeans
* Click Services
* Right Click on Servers
* Click Add Server
* Select Tomcat
* Select the directory where you extracted tomcat
* Click Ok

# Load the project from GitHub:

* Start NetBeans. 
* Click Team
* Git
* Clone...
* Enter the repository URL: https://github.com/Sepiidae/cis5210-module-8.git (https://github.com/Sepiidae/cis5210-module-8)
* Click Finish
* Click Open if prompted. 
* Click the Play button, the software should start your default web browser after a period of time if doesn't follow this step
* Open your default browser
* Visit http://localhost:8080/Module8 
* You may need to link the project to your installation of Tomcat 9. Right-click on the project and select Properties, Select "Run", Click server and make sure "Tomcat ..." is selected. Click Ok. 
* Click Run again and see if it starts.
