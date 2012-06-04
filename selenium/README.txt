1) java -jar lib/seleniumserver.jar
2) ant run

note:it will require junit library, you might need to configure it in build.xml

For gwt application, you 'd better use xpath(location mode) to identity html object.

Known bug:
Selenium "Your browser doesnt support Xml Http Request"
Workaround:
1. search for "selenium-ide-common.xul" file in "C:\Documents and
Settings\<your username>\" folder

2. edit it and add the following code in e.g. line 64:

<script type="application/x-javascript"
src="chrome://selenium-ide/content/selenium/scripts/xmlextras.js"/>

3. restart Firefox.

see: http://code.google.com/p/selenium/issues/detail?id=401 
