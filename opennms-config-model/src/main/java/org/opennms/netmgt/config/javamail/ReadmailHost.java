/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2015 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2015 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

/**
 * This class was original generated with Castor, but is no longer.
 */
package org.opennms.netmgt.config.javamail;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Define the host and port of a service for reading email.
 *
 *
 *
 * @version $Revision$ $Date$
 */

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import org.opennms.core.xml.ValidateUsing;

@XmlRootElement(name="readmail-host")
@XmlAccessorType(XmlAccessType.FIELD)
@ValidateUsing("javamail-configuration.xsd")
@SuppressWarnings("all") public class ReadmailHost implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _host.
     */
    private java.lang.String _host = "127.0.0.1";

    /**
     * Field _port.
     */
    private long _port = 110;

    /**
     * keeps track of state for field: _port
     */
    private boolean _has_port;

    /**
     * Basically any attributes that help setup the javamailer's
     * confusing set of properties.
     *
     *
     */
    private org.opennms.netmgt.config.javamail.ReadmailProtocol _readmailProtocol;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReadmailHost() {
        super();
        setHost("127.0.0.1");
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deletePort(
    ) {
        this._has_port= false;
    }

    /**
     * Overrides the java.lang.Object.equals method.
     *
     * @param obj
     * @return true if the objects are equal.
     */
    @Override()
    public boolean equals(
            final java.lang.Object obj) {
        if ( this == obj )
            return true;

        if (obj instanceof ReadmailHost) {

            ReadmailHost temp = (ReadmailHost)obj;
            if (this._host != null) {
                if (temp._host == null) return false;
                else if (!(this._host.equals(temp._host)))
                    return false;
            }
            else if (temp._host != null)
                return false;
            if (this._port != temp._port)
                return false;
            if (this._has_port != temp._has_port)
                return false;
            if (this._readmailProtocol != null) {
                if (temp._readmailProtocol == null) return false;
                else if (!(this._readmailProtocol.equals(temp._readmailProtocol)))
                    return false;
            }
            else if (temp._readmailProtocol != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'host'.
     *
     * @return the value of field 'Host'.
     */
    public java.lang.String getHost(
    ) {
        return this._host;
    }

    /**
     * Returns the value of field 'port'.
     *
     * @return the value of field 'Port'.
     */
    public long getPort(
    ) {
        return this._port;
    }

    /**
     * Returns the value of field 'readmailProtocol'. The field
     * 'readmailProtocol' has the following description: Basically
     * any attributes that help setup the javamailer's confusing
     * set of properties.
     *
     *
     *
     * @return the value of field 'ReadmailProtocol'.
     */
    public org.opennms.netmgt.config.javamail.ReadmailProtocol getReadmailProtocol(
    ) {
        return this._readmailProtocol;
    }

    /**
     * Method hasPort.
     *
     * @return true if at least one Port has been added
     */
    public boolean hasPort(
    ) {
        return this._has_port;
    }

    /**
     * Overrides the java.lang.Object.hashCode method.
     * <p>
     * The following steps came from <b>Effective Java Programming
     * Language Guide</b> by Joshua Bloch, Chapter 3
     *
     * @return a hash code value for the object.
     */
    @Override
    public int hashCode(
    ) {
        int result = 17;

        long tmp;
        if (_host != null) {
           result = 37 * result + _host.hashCode();
        }
        result = 37 * result + (int)(_port^(_port>>>32));
        if (_readmailProtocol != null) {
           result = 37 * result + _readmailProtocol.hashCode();
        }

        return result;
    }

    /**
     * Method isValid.
     *
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     *
     *
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     *
     *
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'host'.
     *
     * @param host the value of field 'host'.
     */
    public void setHost(
            final java.lang.String host) {
        this._host = host;
    }

    /**
     * Sets the value of field 'port'.
     *
     * @param port the value of field 'port'.
     */
    public void setPort(
            final long port) {
        this._port = port;
        this._has_port = true;
    }

    /**
     * Sets the value of field 'readmailProtocol'. The field
     * 'readmailProtocol' has the following description: Basically
     * any attributes that help setup the javamailer's confusing
     * set of properties.
     *
     *
     *
     * @param readmailProtocol the value of field 'readmailProtocol'
     */
    public void setReadmailProtocol(
            final org.opennms.netmgt.config.javamail.ReadmailProtocol readmailProtocol) {
        this._readmailProtocol = readmailProtocol;
    }

    /**
     * Method unmarshal.
     *
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled
     * org.opennms.netmgt.config.javamail.ReadmailHost
     */
    public static org.opennms.netmgt.config.javamail.ReadmailHost unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.opennms.netmgt.config.javamail.ReadmailHost) Unmarshaller.unmarshal(org.opennms.netmgt.config.javamail.ReadmailHost.class, reader);
    }

    /**
     *
     *
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
