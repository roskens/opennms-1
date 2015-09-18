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
package org.opennms.netmgt.config.charts;

  //---------------------------------/
//- Imported classes and packages -/
//---------------------------------/
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Title.
 *
 * @version $Revision$ $Date$
 */
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import org.opennms.core.xml.ValidateUsing;

@XmlRootElement(name = "title")
@XmlAccessorType(XmlAccessType.FIELD)
@ValidateUsing("chart-configuration.xsd")
@SuppressWarnings("all")
public class Title implements java.io.Serializable {

      //--------------------------/
    //- Class/Member Variables -/
    //--------------------------/
    /**
     * Field _value.
     */
    @XmlAttribute(name = "value")
    private java.lang.String _value;

    /**
     * Field _font.
     */
    @XmlAttribute(name = "font")
    private java.lang.String _font;

    /**
     * Field _pitch.
     */
    @XmlAttribute(name = "pitch")
    private Integer _pitch;

    /**
     * Field _style.
     */
    @XmlAttribute(name = "style")
    private java.lang.String _style;

    /**
     * Field _rgb.
     */
    @XmlElement(name = "rgb")
    private org.opennms.netmgt.config.charts.Rgb _rgb;

      //----------------/
    //- Constructors -/
    //----------------/
    public Title() {
        super();
    }

      //-----------/
    //- Methods -/
    //-----------/
    /**
     */
    public void deletePitch() {
        this._pitch = null;
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
        if (this == obj) {
            return true;
        }

        if (obj instanceof Title) {

            Title temp = (Title) obj;
            if (this._value != null) {
                if (temp._value == null) {
                    return false;
                } else if (!(this._value.equals(temp._value))) {
                    return false;
                }
            } else if (temp._value != null) {
                return false;
            }
            if (this._font != null) {
                if (temp._font == null) {
                    return false;
                } else if (!(this._font.equals(temp._font))) {
                    return false;
                }
            } else if (temp._font != null) {
                return false;
            }
            if (this._pitch != null) {
                if (temp._pitch == null) {
                    return false;
                } else if (!(this._pitch.equals(temp._pitch))) {
                    return false;
                }
            } else if (temp._pitch != null) {
                return false;
            }
            if (this._style != null) {
                if (temp._style == null) {
                    return false;
                } else if (!(this._style.equals(temp._style))) {
                    return false;
                }
            } else if (temp._style != null) {
                return false;
            }
            if (this._rgb != null) {
                if (temp._rgb == null) {
                    return false;
                } else if (!(this._rgb.equals(temp._rgb))) {
                    return false;
                }
            } else if (temp._rgb != null) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Returns the value of field 'font'.
     *
     * @return the value of field 'Font'.
     */
    public java.lang.String getFont() {
        return this._font;
    }

    /**
     * Returns the value of field 'pitch'.
     *
     * @return the value of field 'Pitch'.
     */
    public Integer getPitch() {
        return this._pitch == null ? 0 : this._pitch;
    }

    /**
     * Returns the value of field 'rgb'.
     *
     * @return the value of field 'Rgb'.
     */
    public org.opennms.netmgt.config.charts.Rgb getRgb() {
        return this._rgb;
    }

    /**
     * Returns the value of field 'style'.
     *
     * @return the value of field 'Style'.
     */
    public java.lang.String getStyle() {
        return this._style;
    }

    /**
     * Returns the value of field 'value'.
     *
     * @return the value of field 'Value'.
     */
    public java.lang.String getValue() {
        return this._value;
    }

    /**
     * Method hasPitch.
     *
     * @return true if at least one Pitch has been added
     */
    public boolean hasPitch() {
        return this._pitch != null;
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
    public int hashCode() {
        int result = 17;

        long tmp;
        if (_value != null) {
            result = 37 * result + _value.hashCode();
        }
        if (_font != null) {
            result = 37 * result + _font.hashCode();
        }
        if (_pitch != null) {
            result = 37 * result + _pitch.hashCode();
        }
        if (_style != null) {
            result = 37 * result + _style.hashCode();
        }
        if (_rgb != null) {
            result = 37 * result + _rgb.hashCode();
        }

        return result;
    }

    /**
     * Method isValid.
     *
     * @return true if this object is valid according to the schema
     */
    public boolean isValid() {
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
     * Sets the value of field 'font'.
     *
     * @param font the value of field 'font'.
     */
    public void setFont(
            final java.lang.String font) {
        this._font = font;
    }

    /**
     * Sets the value of field 'pitch'.
     *
     * @param pitch the value of field 'pitch'.
     */
    public void setPitch(
            final Integer pitch) {
        this._pitch = pitch;
    }

    /**
     * Sets the value of field 'rgb'.
     *
     * @param rgb the value of field 'rgb'.
     */
    public void setRgb(
            final org.opennms.netmgt.config.charts.Rgb rgb) {
        this._rgb = rgb;
    }

    /**
     * Sets the value of field 'style'.
     *
     * @param style the value of field 'style'.
     */
    public void setStyle(
            final java.lang.String style) {
        this._style = style;
    }

    /**
     * Sets the value of field 'value'.
     *
     * @param value the value of field 'value'.
     */
    public void setValue(
            final java.lang.String value) {
        this._value = value;
    }

    /**
     * Method unmarshal.
     *
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.opennms.netmgt.config.charts.Titl
     */
    public static org.opennms.netmgt.config.charts.Title unmarshal(
            final java.io.Reader reader)
            throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.opennms.netmgt.config.charts.Title) Unmarshaller.unmarshal(org.opennms.netmgt.config.charts.Title.class, reader);
    }

    /**
     *
     *
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate()
            throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
