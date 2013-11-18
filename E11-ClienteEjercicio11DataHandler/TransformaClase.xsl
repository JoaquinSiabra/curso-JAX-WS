<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="ISO-8859-1" indent="yes"/>
	<xsl:template match="*">
		<html>
		    <head>Salida del fichero Clase.xml</head>
		    <body>
		        <table border="1">
		          <tr>
		              <th bgcolor="blue"><font color="white">Nombre</font></th>
		              <th bgcolor="blue"><font color="white">Provincia</font></th>
		          </tr>
		          <xsl:apply-templates/>
		        </table>
		    </body>
		</html>
	</xsl:template>
	<xsl:template match="Alumno">
		<tr>
		    <xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="Nombre">
		<td><xsl:value-of select="."/></td>
	</xsl:template>
	<xsl:template match="Provincia">
		<td><xsl:value-of select="."/></td>
	</xsl:template>
</xsl:stylesheet>

