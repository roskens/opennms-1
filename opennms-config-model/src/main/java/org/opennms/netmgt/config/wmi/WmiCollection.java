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
package org.opennms.netmgt.config.wmi;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * A grouping of WMI related RRD parms and WMI object groups
 *
 * @version $Revision$ $Date$
 */

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import org.opennms.core.xml.ValidateUsing;

@XmlRootElement(name="wmi-collection")
@XmlAccessorType(XmlAccessType.FIELD)
@ValidateUsing("wmi-datacollection.xsd")
@SuppressWarnings("all") public class WmiCollection implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name.
     */
    @XmlAttribute(name="name", required = true)
    private java.lang.String _name;

    /**
     * RRD parms
     */
    @XmlElement(name="rrd")
    private org.opennms.netmgt.config.wmi.Rrd _rrd;

    /**
     * WMI object groups
     */
    @XmlElement(name="wpms")
    private org.opennms.netmgt.config.wmi.Wpms _wpms;


      //----------------/
     //- Constructors -/
    //----------------/

    public WmiCollection() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

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

        if (obj instanceof WmiCollection) {

            WmiCollection temp = (WmiCollection)obj;
            if (this._name != null) {
                if (temp._name == null) return false;
                else if (!(this._name.equals(temp._name)))
                    return false;
            }
            else if (temp._name != null)
                return false;
            if (this._rrd != null) {
                if (temp._rrd == null) return false;
                else if (!(this._rrd.equals(temp._rrd)))
                    return false;
            }
            else if (temp._rrd != null)
                return false;
            if (this._wpms != null) {
                if (temp._wpms == null) return false;
                else if (!(this._wpms.equals(temp._wpms)))
                    return false;
            }
            else if (temp._wpms != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'name'.
     *
     * @return the value of field 'Name'.
     */
    public java.lang.String getName(
    ) {
        return this._name;
    }

    /**
     * Returns the value of field 'rrd'. The field 'rrd' has the
     * following description: RRD parms
     *
     * @return the value of field 'Rrd'.
     */
    public org.opennms.netmgt.config.wmi.Rrd getRrd(
    ) {
        return this._rrd;
    }

    /**
     * Returns the value of field 'wpms'. The field 'wpms' has the
     * following description: WMI object groups
     *
     * @return the value of field 'Wpms'.
     */
    public org.opennms.netmgt.config.wmi.Wpms getWpms(
    ) {
        return this._wpms;
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
        if (_name != null) {
           result = 37 * result + _name.hashCode();
        }
        if (_rrd != null) {
           result = 37 * result + _rrd.hashCode();
        }
        if (_wpms != null) {
           result = 37 * result + _wpms.hashCode();
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
     * Sets the value of field 'name'.
     *
     * @param name the value of field 'name'.
     */
    public void setName(
            final java.lang.String name) {
        this._name = name;
    }

    /**
     * Sets the value of field 'rrd'. The field 'rrd' has the
     * following description: RRD parms
     *
     * @param rrd the value of field 'rrd'.
     */
    public void setRrd(
            final org.opennms.netmgt.config.wmi.Rrd rrd) {
        this._rrd = rrd;
    }

    /**
     * Sets the value of field 'wpms'. The field 'wpms' has the
     * following description: WMI object groups
     *
     * @param wpms the value of field 'wpms'.
     */
    public void setWpms(
            final org.opennms.netmgt.config.wmi.Wpms wpms) {
        this._wpms = wpms;
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
     * org.opennms.netmgt.config.wmi.WmiCollection
     */
    public static org.opennms.netmgt.config.wmi.WmiCollection unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.opennms.netmgt.config.wmi.WmiCollection) Unmarshaller.unmarshal(org.opennms.netmgt.config.wmi.WmiCollection.class, reader);
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
