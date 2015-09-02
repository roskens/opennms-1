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
package org.opennms.netmgt.xml.rtc;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class EuiLevel.
 *
 * @version $Revision$ $Date$
 */

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import org.opennms.core.xml.ValidateUsing;

@XmlRootElement(name="euiLevel")
@XmlAccessorType(XmlAccessType.FIELD)
@ValidateUsing("rtceui.xsd")
@SuppressWarnings("all") public class EuiLevel implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The header
     */
    private org.opennms.netmgt.xml.rtc.Header _header;

    /**
     * category value and nodes belonging to
     *  it
     */
    private java.util.List<org.opennms.netmgt.xml.rtc.Category> _categoryList;


      //----------------/
     //- Constructors -/
    //----------------/

    public EuiLevel() {
        super();
        this._categoryList = new java.util.ArrayList<org.opennms.netmgt.xml.rtc.Category>();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     *
     *
     * @param vCategory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCategory(
            final org.opennms.netmgt.xml.rtc.Category vCategory)
    throws java.lang.IndexOutOfBoundsException {
        this._categoryList.add(vCategory);
    }

    /**
     *
     *
     * @param index
     * @param vCategory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void addCategory(
            final int index,
            final org.opennms.netmgt.xml.rtc.Category vCategory)
    throws java.lang.IndexOutOfBoundsException {
        this._categoryList.add(index, vCategory);
    }

    /**
     * Method enumerateCategory.
     *
     * @return an Enumeration over all possible elements of this
     * collection
     */
    public java.util.Enumeration<org.opennms.netmgt.xml.rtc.Category> enumerateCategory(
    ) {
        return java.util.Collections.enumeration(this._categoryList);
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

        if (obj instanceof EuiLevel) {

            EuiLevel temp = (EuiLevel)obj;
            if (this._header != null) {
                if (temp._header == null) return false;
                else if (!(this._header.equals(temp._header)))
                    return false;
            }
            else if (temp._header != null)
                return false;
            if (this._categoryList != null) {
                if (temp._categoryList == null) return false;
                else if (!(this._categoryList.equals(temp._categoryList)))
                    return false;
            }
            else if (temp._categoryList != null)
                return false;
            return true;
        }
        return false;
    }

    /**
     * Method getCategory.
     *
     * @param index
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     * @return the value of the org.opennms.netmgt.xml.rtc.Category
     * at the given index
     */
    public org.opennms.netmgt.xml.rtc.Category getCategory(
            final int index)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._categoryList.size()) {
            throw new IndexOutOfBoundsException("getCategory: Index value '" + index + "' not in range [0.." + (this._categoryList.size() - 1) + "]");
        }

        return (org.opennms.netmgt.xml.rtc.Category) _categoryList.get(index);
    }

    /**
     * Method getCategory.Returns the contents of the collection in
     * an Array.  <p>Note:  Just in case the collection contents
     * are changing in another thread, we pass a 0-length Array of
     * the correct type into the API call.  This way we <i>know</i>
     * that the Array returned is of exactly the correct length.
     *
     * @return this collection as an Array
     */
    public org.opennms.netmgt.xml.rtc.Category[] getCategory(
    ) {
        org.opennms.netmgt.xml.rtc.Category[] array = new org.opennms.netmgt.xml.rtc.Category[0];
        return (org.opennms.netmgt.xml.rtc.Category[]) this._categoryList.toArray(array);
    }

    /**
     * Method getCategoryCollection.Returns a reference to
     * '_categoryList'. No type checking is performed on any
     * modifications to the Vector.
     *
     * @return a reference to the Vector backing this class
     */
    public java.util.List<org.opennms.netmgt.xml.rtc.Category> getCategoryCollection(
    ) {
        return this._categoryList;
    }

    /**
     * Method getCategoryCount.
     *
     * @return the size of this collection
     */
    public int getCategoryCount(
    ) {
        return this._categoryList.size();
    }

    /**
     * Returns the value of field 'header'. The field 'header' has
     * the following description: The header
     *
     * @return the value of field 'Header'.
     */
    public org.opennms.netmgt.xml.rtc.Header getHeader(
    ) {
        return this._header;
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
        if (_header != null) {
           result = 37 * result + _header.hashCode();
        }
        if (_categoryList != null) {
           result = 37 * result + _categoryList.hashCode();
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
     * Method iterateCategory.
     *
     * @return an Iterator over all possible elements in this
     * collection
     */
    public java.util.Iterator<org.opennms.netmgt.xml.rtc.Category> iterateCategory(
    ) {
        return this._categoryList.iterator();
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
     */
    public void removeAllCategory(
    ) {
        this._categoryList.clear();
    }

    /**
     * Method removeCategory.
     *
     * @param vCategory
     * @return true if the object was removed from the collection.
     */
    public boolean removeCategory(
            final org.opennms.netmgt.xml.rtc.Category vCategory) {
        boolean removed = _categoryList.remove(vCategory);
        return removed;
    }

    /**
     * Method removeCategoryAt.
     *
     * @param index
     * @return the element removed from the collection
     */
    public org.opennms.netmgt.xml.rtc.Category removeCategoryAt(
            final int index) {
        java.lang.Object obj = this._categoryList.remove(index);
        return (org.opennms.netmgt.xml.rtc.Category) obj;
    }

    /**
     *
     *
     * @param index
     * @param vCategory
     * @throws java.lang.IndexOutOfBoundsException if the index
     * given is outside the bounds of the collection
     */
    public void setCategory(
            final int index,
            final org.opennms.netmgt.xml.rtc.Category vCategory)
    throws java.lang.IndexOutOfBoundsException {
        // check bounds for index
        if (index < 0 || index >= this._categoryList.size()) {
            throw new IndexOutOfBoundsException("setCategory: Index value '" + index + "' not in range [0.." + (this._categoryList.size() - 1) + "]");
        }

        this._categoryList.set(index, vCategory);
    }

    /**
     *
     *
     * @param vCategoryArray
     */
    public void setCategory(
            final org.opennms.netmgt.xml.rtc.Category[] vCategoryArray) {
        //-- copy array
        _categoryList.clear();

        for (int i = 0; i < vCategoryArray.length; i++) {
                this._categoryList.add(vCategoryArray[i]);
        }
    }

    /**
     * Sets the value of '_categoryList' by copying the given
     * Vector. All elements will be checked for type safety.
     *
     * @param vCategoryList the Vector to copy.
     */
    public void setCategory(
            final java.util.List<org.opennms.netmgt.xml.rtc.Category> vCategoryList) {
        // copy vector
        this._categoryList.clear();

        this._categoryList.addAll(vCategoryList);
    }

    /**
     * Sets the value of '_categoryList' by setting it to the given
     * Vector. No type checking is performed.
     * @deprecated
     *
     * @param categoryList the Vector to set.
     */
    public void setCategoryCollection(
            final java.util.List<org.opennms.netmgt.xml.rtc.Category> categoryList) {
        this._categoryList = categoryList;
    }

    /**
     * Sets the value of field 'header'. The field 'header' has the
     * following description: The header
     *
     * @param header the value of field 'header'.
     */
    public void setHeader(
            final org.opennms.netmgt.xml.rtc.Header header) {
        this._header = header;
    }

    /**
     * Method unmarshal.
     *
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled org.opennms.netmgt.xml.rtc.EuiLevel
     */
    public static org.opennms.netmgt.xml.rtc.EuiLevel unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.opennms.netmgt.xml.rtc.EuiLevel) Unmarshaller.unmarshal(org.opennms.netmgt.xml.rtc.EuiLevel.class, reader);
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