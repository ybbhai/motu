# Motu Project
@author Project manager <rdedianous@cls.fr>  
@author Product owner <tjolibois@cls.fr>  
@author Scrum master, software architect <smarty@cls.fr>  

>How to read this file? 
Use a markdown reader: 
plugins [chrome](https://chrome.google.com/webstore/detail/markdown-preview/jmchmkecamhbiokiopfpnfgbidieafmd?utm_source=chrome-app-launcher-info-dialog) exists (Once installed in Chrome, open URL chrome://extensions/, and check "Markdown Preview"/Authorise access to file URL.), 
or for [firefox](https://addons.mozilla.org/fr/firefox/addon/markdown-viewer/)  (anchor tags do not work)
and also plugin for [notepadd++](https://github.com/Edditoria/markdown_npp_zenburn).

>Be careful: Markdown format has issue while rendering underscore "\_" character which can lead to bad variable name or path.


#Summary
* [Overview](#Overview)
* [Development environment](#DEV)
* [Compilation](#COMPILATION)
* [Packaging](#Packaging)
* [Installation](#Installation)
* [Configuration](#Configuration)
  * [Configuration directory structure](#ConfigurationFolderStructure)
  * [Business settings](#ConfigurationBusiness)
  * [System settings](#ConfigurationSystem)
* [Start, Stop and Motu commands](#SS)

#<a name="Overview">Overview</a>
Motu project is a robust web server used to distribute data. [To be completed]


#<a name="DEV">Development environment</a>

## Configure eclipse development environment
* Add variable in order to run/debug Motu on your localhost:  
From Eclipse menu bar: Run/Debug > String substitution  
MOTU_HOME=J:\dev\cmems-cis-motu\motu-install-dir  
This variable represent the folder where Motu is installed.  

* From a file explorer, create folders:  
$MOTU_HOME/log  
$MOTU_HOME/config  
$MOTU_HOME/data-deliveries  

* Copy configuration files from Eclipse to configuration folder:  
Note: If you do not have any motu-config folder available, default configuration files are folders are available in the "/motu-web/src/main/resources" folder  
If "motu-config" exists, copy:  
cp $eclipse/motu-config/src/config/common/config $MOTU_HOME/config  
cp $eclipse/motu-config/src/config/cls/dev-win7 $MOTU_HOME/config  

 
* Add an application server in Eclipse: Window>Preferences>Server>Runtime environment  
Name=Apache Tomcat 7.0  
Tomcat installation directory=C:\dvlt\java\servers\tomcat\apache-tomcat-7.0.65  

* J2EE perspective > Under the Servers view > Right click > New > Server  
Server Name: Tomcat v7.0 Server at localhost  

* Edit /Servers/Tomcat v7.0 Server at localhost/server.xml and add  
```
<Context docBase="J:/dev/cmems-cis-motu/motu-install-dir/data-deliveries" path="/mis-gateway/deliveries" />
```  
just under the line:  
```
<Host appBase="webapps" autoDeploy="true" name="localhost" unpackWARs="true">
```  
Now Tomcat can serve downloaded files directly   
 
## Run/Debug Motu

Click Debug configurations...> Under Apache Tomcat, debug "Motu Tomcat v7.0 Server at localhost"

Open a web browser and test:  
http://localhost:8080/motu-web/Motu?action=ping  

it displays "OK - response action=ping"  


For more details about Eclipse launchers, refers to /motu-parent/README-eclipseLaunchers.md.


#<a name="COMPILATION">Compilation</a>
This step is used to generate Java ARchives (or war).
```
cd /motu-parent  
mvn clean install -Dmaven.test.skip=true  
```  

All projects are built under target folder.  
The Motu war is built under "/motu-web/target/motu-web-X.Y.Z-classifier.war"  
It embeds all necessary jar libraries.  

#<a name="Packaging">Packaging</a>
This step includes the compilation step. Once all projects are compiled, it groups all archive in a same folder in order to easy the client delivery.  
You have to set ANT script inputs parameter before running it. See /motu-distribution/build.xml header to get more details about inputs.
```
cd /motu-distribution  
ant  
cd target-ant/delivery/YYYYMMDDhhmmssSSS  
```

Three folders are built containing archives :

* src: contains sources of motu application and the configuration files
* motu: contains the built application and the products (java, tomcat, cdo)
* config: contains two kind of archives:
  * motu-config-X.Y.Z-classifier-$timestamp-$target.tar.gz:  the built configurations for each target platform  
  * motu-web-static-files-X.Y.Z-classifier-$timestamp-$target.tar.gz: The public static files (css, js) for each target platform 


#<a name="Installation">Installation</a>
## Install Motu from archives files  
### Install Motu on a <a name="IntallDU">Dissemination Unit</a>  

Copy the installation archives and unzip them.  
```
cd /opt/cmems-cis  
cp motu-products-A.B.tar.gz .  
cp motu-distribution-X.Y.Z.tar.gz .  
cp motu-config-X.Y.Z-$BUILDID-$TARGET-$PLATFORM.tar.gz .  
tar xzf motu-products-A.B.tar.gz  
tar xzf motu-distribution-X.Y.Z.tar.gz  
tar xzf motu-config-X.Y.Z-$BUILDID-$TARGET-$PLATFORM.tar.gz  
cd motu
```
 
 
If you do not use a central entity to serve public static files, you can eventually  extract the archive below 
and serve it directly by configuring motu:  
```
tar xvzf motu-web-static-files-X.Y.Z-classifier-$timestamp-$target.tar.gz  
```
Then edit conf/server.xml:  
```
<Host appBase="webapps" [...]  
        <!-- CLS#SMA: Used to serve public static files -->  
        <Context docBase="${motu-config-dir}/../motu" path="/motu"/>  
 [...]  
```

Otherwise refers to [Install Motu web public static files on a central server](#IntallPublicFilesOnCentralServer)
 
Platform is installed and configured. Refers to [Configuration](#Configuration) for check configuration before [starting Motu](#SS).


__Installation folder structure__
  
Once archives have been extracted, a "motu" folder is created and contains several sub-folders and files:

* __config:__ Folder which contains the motu configuration files. Refers to [Configuration](#Configuration) for more details.
* __data:__ Folder used to managed Motu data.
  * __download__:  Folder used to save the products downloaded. This folder is sometimes elsewhere, for example in Motu v2: /datalocal/atoll/mis-gateway/deliveries/.
* __log:__ Folder which contains all log files. Daily logging are suffixed by yyyy-MM-dd.
  * __errors.log:__ Motu application errors
  * __warnings.log:__ Motu application warnings
  * __logbook.log:__ Motu application logs (errors and warning are included)
  * __tomcat-motu.log:__ Apache tomcat console output and errors
  * __tomcat-motu-catalina.out:__ CATALINA_OUT environment variable used by catalina engine to write its logs.
  * __queue.log:__ Motu queue server logs messages
* __motu file:__ Script used to start, stop Motu application.  Refers to [Start & Stop Motu](#SS) for more details.
* __pid:__ Folder which contains pid files of the running Motu application.
  * __tomcat-motu.pid:__ Contains the UNIX PID of the Motu process.
* __products:__ Folder which contains Java, Tomcat ($CATALINE_BASE folder) and CDO products.
  * __apache-tomcat-X.Y.Z:__ Apache tomcat default installation folder from http://tomcat.apache.org/
  * __cdo-group:__ CDO tools from https://code.zmaw.de/projects/cdo
  * __jdkX.Y.Z:__ Oracle JDK from http://www.oracle.com/technetwork/java
  * __version-products.txt:__ Contains the version of the current Motu products.
* __tomcat-motu:__ Tomcat is deployed inside this folder. This folder is built by setting the $CATALINE_HOME environment variable.
* __version-distribution.txt file:__ Contains the version of the current Motu distribution.



### Install Motu public static files from a <a name="IntallPublicFilesOnCentralServer">central server</a>  
Extract this archive on a server.
```
tar xvzf motu-web-static-files-X.Y.Z-classifier-$timestamp-$target.tar.gz  
```
Then use a server to make these extracted folders and files accessible from an HTTP address.
 
Example: The archive contains a motu folder at its root. Then a particular file is "motu/css/motu/motu.css" and this file is served by the URL   http://resources.myocean.eu/motu/css/motu/motu.css in the CMEMS CIS context.   



## Setup a front Apache HTTPd server  
See sample of the Apache HTTPd configuration in the folder: config/apache-httpd-conf-sample  
The configuration is described for Apache2  

* __apache2.conf:__ Use to show how timeout parameter shall be set
* __httpd.conf:__ Main apache configuration file used for Motu
* __enableApacheModules.sh__ Describe the Apache modules to enable


#<a name="Configuration">Configuration</a>

This chapter describes the Motu configuration settings.  
All the configuration files are set in the $installDir/motu/config folder.  

* [Configuration directory structure](#ConfigurationFolderStructure)
* [Business settings](#ConfigurationBusiness)
* [System settings](#ConfigurationSystem)
  
##<a name="ConfigurationFolderStructure">Configuration directory structure</a>
cd $installDir/motu/config
  
* __config:__ Folder which contains the motu configuration files.
  * __motu.properties:__ JVM memory, network ports of JVM (JMX, Debug) and Tomcat (HTTP, HTTPS, AJP, SHUTDOWN). CAS SSO server settings.
  * __motuConfiguration.xml:__ Motu settings (Service, Catalog via Thredds, Proxy, Queues, ....)
  * __log4j.xml:__ Log4j v2 configuration file
  * __standardNames.xml:__ Contains the standard names [TBD]
  * __version-configuration.txt:__ Contains the version of the current Motu configuration.
  
##<a name="ConfigurationBusiness">Business settings</a>
### motuConfiguration.xml: Motu business settings  

You can configure 3 main categories:  

* [MotuConfig node : general settings](#BSmotuConfig)
* [ConfigService node : catalog settings](#BSconfigService)
* [QueueServerConfig node : request queue settings](#BSqueueServerConfig)

####<a name="BSmotuConfig">Attributes defined in motuConfig node</a>

##### defaultService  
A string representing the default action in the URL /Motu?action=$defaultService  
The default one is "listservices".  
All values can be found in the method USLRequestManager#onNewRequest with the different ACTION_NAME.  

##### logFormat  
A string either "xml" or "cvs" to select the format in which log message are written.  
If this attribute is not set, the default format is "xml".  

##### dataBlockSize
Number of data in Ko that can be read in the same time. Default is 2048Kb.

##### maxSizePerFile
@Deprecated from v3 This parameter is not used. 
Number of data in Megabytes that can be written and download for a Netcdf file. Default is 1024Mb. 

##### maxSizePerFileTDS
Number of data in Megabytes that can be written and download for a Netcdf file. Default is 1024Mb. 

##### extractionPath
The absolute path where files downloaded from TDS are stored.  
For example: /opt/cmems-cis/motu/data/download
It is recommended to have an hard drive with very good performances in write mode.
It is recommended to have a dedicated partition disk to avoid freezing Motu if the hard drive is full.

##### downloadHttpUrl
Http URL used to download files stored in the "extractionPath" described above. It is used to allow users to download the result data files.  
This URL is concatenated to the result data file name found in the folder "extractionPath".  
When a frontal HTTPd server is used, it is this URL that shall be configured to access to the folder "extractionPath".  
String with format ${var} will be substituted with Java property variables. @See System.getProperty(var)  

##### <a name="motuConfig-httpBaseRef">httpBaseRef</a>
Http URL used to serve files from to the path where archive __motu-web-static-files-X.Y.Z-classifier-buildId.tar.gz__ has been extracted.  
For example: This value http://resources.myocean.eu server a folder which contains motu/css/motu/motu.css.  
It so enable to server http://resources.myocean.eu/motu/css/motu/motu.css

        
##### cleanExtractionFileInterval
In minutes, the waiting period admitted to keep the file that results of an extraction data request.  
Default = 60min

##### cleanRequestInterval
In minutes, the waiting period admitted to keep the status response of an extraction data request.  
Default = 60min

##### runCleanInterval
In minutes, the waiting period admitted to clean request status in memory and extraction file.  
Default = 1min

##### extractionFilePatterns
Patterns (as regular expression) that match extraction file name to delete in folders:

* java.io.tmpdir
* extractionPath

Default is ".*\\.nc$|.*\\.zip$|.*\\.tar$|.*\\.gz$|wps_output_.*$|wps_response_.*$"  


##### extractionFileCacheSize
Size in Mbytes.  
A clean job runs each <runCleanInterval>. File with a size higher than this value are deleted by this job.
If value is zero: no delete.  
Default value = 0.


##### runGCInterval
@Deprecated from v3 This parameter is not used. 


##### httpDocumentRoot
@Deprecated from v3 This parameter is not used. 
Document root of the servlet server.       
        
##### useAuthentication
@Deprecated from v3 This parameter is not used. It is redundant with parameter config/motu.properties#cas-activated.


##### defaultActionIsListServices
@Deprecated from v3 This parameter is not used.  

##### Configure the Proxy settings  
@Deprecated from v3 This parameter is not used.
Proxy settings are not used on Motu:  

* __useProxy__
* __proxyHost__
* __proxyPort__
* __proxyLogin__
* __proxyPwd__


#### <a name="BSconfigService">Attributes defined in configService node</a>

##### name
String to set the config service name

##### group
String which describes the group

##### description
String which describes the service

##### profiles
Optional string containing one value, several values separated by a comma.  
Used to manage access right from a SSO cas server.  
In the frame of CMEMS, three profiles exist:  

* internal: internal users of the CMEMS project  
* major: major accounts  
* external: external users  

Otherwise, it's possible to configure as many profiles as needed.  
Profiles are configured in LDAP within the attribute "memberUid" of each user. This attribute is read by CAS and is sent to Motu 
once a user is logged in, in order to check if it matches profiles configured in Motu to allow a user accessing the data.  
In LDAP, "memberUid" attribute can be empty, contains one value or several values separated by a comma.  


##### veloTemplatePrefix
Optional, string used to target the default velocity template. It is used to set a specific theme.  
Value is the velocity template file name without the extension.  
Default value is "index".

##### httpBaseRef
Optional, used to override [motuConfig httpBaseRef](#motuConfig-httpBaseRef) attribute for this specific service.

##### defaultLanguage
@Deprecated from v3 This parameter is not used.


#### Attributes defined in catalog node

##### name
This catalog name refers a TDS catalog name available from the URL: http://$ip:$port/thredds/m_HR_MOD.xml
Example: m_HR_OBS.xml 

##### type
Example: tds

##### ncss
Without this attribute, Motu connects to TDS with Opendap protocol. If this attribute is set to "enabled" connects to TDS with ncss protocol in order to improve performance.  
We recommend to use "enabled".
Values are: "enabled", "disable" or empty

##### urlSite
TDS URL  
For example: http://$ip:$port/thredds/


####<a name="BSqueueServerConfig">Attributes defined in queueServerConfig node</a>

##### maxPoolAnonymous
Maximum number of request that an anonymous user can send to Motu before throwing an error message.  
Value of -1 means no check is done.  
Default value is 10

##### maxPoolAuth
Maximum number of request that an authenticated user can send to Motu before throwing an error message.  
Value of -1 means no check is done.  
Default value is 1

##### defaultPriority
@Deprecated from v3 This parameter is not used.


#### Attributes defined in queues
##### id
An id to identify the queue.

##### description
Description of the queue.

##### batch
@Deprecated from v3 This parameter is not used.

##### Child node: maxThreads
Use to build a java.util.concurrent.ThreadPoolExecutor an to set "corePoolSize" and "maximumPoolSize" values.  
Default value is 1  

##### Child node: maxPoolSize
Request are put in a queue before being executed by the ThreadPoolExecutor. Before being put in the queue, the queue size
is checked. If it is upper than this value maxPoolSize, an error message is returned.
Value of -1 means no check is done.  
Default value is -1


##### Child node: dataThreshold
Size in Mbytes. A request has a size. The queue in which this request will be processed is defined by the request size.
All queues are sorted by size ascending. A request is put in the last queue which has a size lower than the request size.
If the request size if higher than the bigger queue dataThreshold, request is not treated and an error message is returned.


##### Child node: lowPriorityWaiting
@Deprecated from v3 This parameter is not used.

##<a name="ConfigurationSystem">System settings</a>

### motu.properties: Motu system settings  

#### Java options
The three parameters below are used to tune the Java Virtual Machine:  
   # -server: tells the Hostspot compiler to run the JVM in "server" mode (for performance)  
tomcat-motu-jvm-javaOpts=-server -Xmx4096M -Xms512M -XX:PermSize=128M -XX:MaxPermSize=512M  
tomcat-motu-jvm-port-jmx=9010  
tomcat-motu-jvm-address-debug=9090  


#### Tomcat network ports
The parameters below are used to set the different network ports used by Apache Tomcat.  
At startup, these ports are set in the file "$installdir/motu/tomcat-motu/conf/server.xml".  
But if this file already exist, it won't be replaced. So in order to apply these parameters, remove the file "$installdir/motu/tomcat-motu/conf/server.xml".
tomcat-motu-port-http=9080  
  # HTTPs is in a common way managed from a frontal Apache HTTPd server. If you really need to use it from Tomcat, you have to tune the SSL certificates and the protocols directly in the file "$installdir/motu/tomcat-motu/conf/server.xml".
tomcat-motu-port-https=9443  
tomcat-motu-port-ajp=9009  
tomcat-motu-port-shutdown=9005  



#### CAS SSO server

   # true or false to enable the SSO connection to a CAS server
cas-activated=false
  
   # Cas server configuration to allow Motu to access to it  
   # @see https://wiki.jasig.org/display/casc/configuring+the+jasig+cas+client+for+java+in+the+web.xml  
     
   # The Cas server URL
cas-server-url=https://cas-cis.cls.fr/cas  
   # The Motu HTTP server url: example: http://misgw-ddo-qt.cls.fr:9080 or http://motu.cls.fr   
cas-auth-serverName=http://$motuServerIp:$motuServerPort 
   # The proxy callback HTTP URL on the Motu server (this URL can be defined on the frontal Apache HTTPs server)
cas-validationFilter-proxyCallbackUrl=http://$motuServerIp:$motuServerPort/motu-web/proxyCallback

#### Supervision
To enable the status supervision, set the parameter below:
tomcat-motu-urlrewrite-statusEnabledOnHosts=localhost,*.cls.fr

This parameter is used to set the property below in the WEB.XML file:
        <init-param>
            <param-name>statusEnabledOnHosts</param-name>
            <param-value>${tomcat-motu-urlrewrite-statusEnabledOnHosts}</param-value>
        </init-param>
        
For more detail read:
org.tuckey UrlRewriteFilter FILTERS : see http://urlrewritefilter.googlecode.com/svn/trunk/src/doc/manual/3.1/index.html


#<a name="SS">Start, Stop and Motu commands</a>  
All operations are done from the Motu installation folder.  
For example:  
``` 
cd /opt/cmems-cis/motu 
```

## Start Motu
Start the Motu process.  
``` 
./motu start  
```

## Stop Motu
``` 
./motu stop
``` 


## Advanced commands
### Restart Motu
``` 
./motu restart
``` 

### Status of the Motu process
``` 
./motu status
``` 

Status are the following: 
 
* __tomcat-motu started__ A pid file exists
* __tomcat-motu stopped__ No pid file exists

### Help about Motu parameters
``` 
./motu ?
``` 


