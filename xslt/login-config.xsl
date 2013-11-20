<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="xml" version="1.0" encoding="UTF-8"
		indent="yes"
	/>

	<xsl:template match="/policy">
	<xsl:comment>
        JBPM Security domain
  </xsl:comment>
		<policy>

			<application-policy name="jbpm">
				<authentication>
					<login-module
						code="org.jboss.security.auth.spi.DatabaseServerLoginModule" flag="required">
						<module-option name="dsJndiName">java:/JbpmDS
						</module-option>
						<module-option name="principalsQuery">
							SELECT PASSWORD_ FROM JBPM_ID_USER WHERE NAME_=? 
           </module-option>
						<module-option name="rolesQuery">
							SELECT g.NAME_ ,'Roles'
							FROM JBPM_ID_USER u,
							JBPM_ID_MEMBERSHIP m,
							JBPM_ID_GROUP g
							WHERE g.TYPE_='security-role'
							AND m.GROUP_ = g.ID_
							AND m.USER_ = u.ID_
							AND u.NAME_=? 
           </module-option>
					</login-module>
				</authentication>
			</application-policy>
      
      <xsl:for-each select="/policy/*">
        <xsl:if test="@name!='soa'">
          <xsl:if test="@name!='jmx-console'">
            <xsl:if test="@name!='web-console'">
              <xsl:comment>Loaded from orignal file: old/login-config.xml</xsl:comment>
              <xsl:copy-of select="current()"/>
              <xsl:comment>----</xsl:comment>
            </xsl:if>
          </xsl:if>
        </xsl:if>
      </xsl:for-each>
			
			<xsl:comment>
				BRMS Platform Security Domain
			</xsl:comment>

			<application-policy name="brms">
      				<authentication>
              			 <login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule" flag="required">
                           		<module-option name="usersProperties">props/brms-users.properties</module-option>
                                       <module-option name="rolesProperties">props/brms-roles.properties</module-option>
                                  </login-module>
                                  </authentication>
                        </application-policy> 
			<application-policy name="jmx-console">
				<authentication>
					<login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule"
						flag="required">
						<module-option name="usersProperties">props/brms-users.properties
						</module-option>
						<module-option name="rolesProperties">props/brms-roles.properties
						</module-option>
					</login-module>
				</authentication>
			</application-policy>
			<application-policy name="web-console">
				<authentication>
					<login-module code="org.jboss.security.auth.spi.UsersRolesLoginModule"
						flag="required">
						<module-option name="usersProperties">props/brms-users.properties
						</module-option>
						<module-option name="rolesProperties">props/brms-roles.properties
						</module-option>
					</login-module>
				</authentication>
			</application-policy>
			<application-policy name="OpenSSOLogin">
				<authentication>
					<login-module code="org.jboss.soa.security.opensso.OpenSSOLoginModule"
						flag="required">
						<module-option name="orgName">opensso</module-option>
						<module-option name="moduleName">DataStore
						</module-option>
						<module-option name="amPropertiesFile">/props/AMConfig.properties
						</module-option>
					</login-module>
				</authentication>
			</application-policy>
		</policy>

	</xsl:template>

	<xsl:template match="/">

		<xsl:apply-templates />
	</xsl:template>

</xsl:stylesheet>
