<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" >
<xsl:template match="TABLE">
<HTML>
   <BODY> 	
      <TABLE border='1' style='table-layout:fixed' width='600'> 
         <TR bgcolor='#FFFF00'>
            <TD>Expected action</TD>
            <TD>HTML display</TD>
         </TR>
         <xsl:for-each select="ROW">
            <TR>   
               <TD><xsl:value-of select='F1'/></TD>
               <TD><xsl:value-of select='F2' disable-output-escaping="yes"/></TD>
            </TR>
         </xsl:for-each>
      </TABLE>
   </BODY>
</HTML>
</xsl:template>
</xsl:stylesheet>

