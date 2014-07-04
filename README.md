# SonarQube TattleTale Plugin #

SonarQube Tattletale is a plugin that collects information about the results of JBoss Tattletale and provides a general view about the project dependencies to SonarQube users.

### Features ###

Used together with Maven and SonarQube, its capable to retrieve some HTML reports about project dependencies (libraries) and show them in your SonarQube dashboard. Some features of this tool are:

* Identify dependencies between libraries
* Find missing classes from the classpath
* Spot if a class/package is located in multiple libraries
* Spot if the same library is located in multiple locations
* With a list of what each library require and provides
* Verify the SerialVersionUID of a class
* Find similar libraries that have different version numbers
* Find libraries without a version number
* Find unused libraries
* Identify signed libraries
* Locate a class in a library
* Get the OSGi status of your project

The plugin collects information about the results of the tool and provides a general view about the project dependencies to Sonar users.

It shows some reports about project dependencies and calculates some metrics related with them, like number of unused libraries, duplicated libraries, libraries without version...

[Check out the product site to download the latest version](http://www.excentia.es/plugins/tattletale/descargar_en.html)