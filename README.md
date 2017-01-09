# agent-orders-server
This is the Server application for Agent's Orders.

The client is here https://github.com/bsoft-biz/confirm-orders

In this application operators can confirm agents orders.


##How to use

###Before using you must rename and configure this file:
* persistence.properties.sample to persistence.properties

###To use oracle database you need to install oracle jdbc into your local maven repository
#### Get Oracle jdbc driver
Download it from oracle.com or get it from `{ORACLE_HOME}\jdbc\lib\`

#### Install Oracle driver
`mvn install:install-file -Dfile={Path/to/your/ojdbc.jar} -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar`

[Wiki page] (https://github.com/bsoft-biz/orders/wiki/How-to-add-Oracle-JDBC-driver-in-your-Maven-local-repository)
