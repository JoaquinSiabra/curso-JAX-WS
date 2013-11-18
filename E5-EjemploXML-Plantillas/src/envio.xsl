<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="text" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
2.0
<xsl:value-of select="/Raiz/Cabecera/NumCOE"/>
I
<xsl:value-of select="/Raiz/Cabecera/Anualidad"/>/0000
<xsl:value-of select="/Raiz/Cabecera/FechaEnvio"/>
1
0
0
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0000 2.00.<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/CodigoMC"/>.<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/DigitoSigno"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0001 <xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumOficinaContable"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0004 #$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0007 <xsl:value-of select="/Raiz/DocumentoContable/Cuerpo/NumExpediente"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0008 <xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumAplicaciones"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0010 <xsl:value-of select="/Raiz/DocumentoContable/Cabecera/Ejercicio"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0011 <xsl:value-of select="/Raiz/DocumentoContable/Cabecera/Ejercicio"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0012 <xsl:value-of select="/Raiz/DocumentoContable/Cuerpo/Seccion"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/>
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0019 <xsl:value-of select="/Raiz/DocumentoContable/Cuerpo/Modificaciones/ImporteTotal"/>#$
<xsl:for-each select="/Raiz/DocumentoContable/Cuerpo/Modificaciones/Modificacion">
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/><xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0013001<xsl:value-of select="./Servicio"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/><xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0014001<xsl:value-of select="./PorPrograma"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/><xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0015001<xsl:value-of select="./Economica"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/><xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0114001<xsl:value-of select="./CodModificacion"/>#$
<xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumCOE"/><xsl:value-of select="/Raiz/DocumentoContable/Cabecera/NumIdTelcon"/>0016001<xsl:value-of select="./Importe"/>#$
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
