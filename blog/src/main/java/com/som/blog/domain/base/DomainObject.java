package com.som.blog.domain.base;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;


/**
 * General class for all entities, that makes it possible to store them in DB.
 *
 * @author ytkach
 * @author zhelezoglo
 */
public abstract class DomainObject implements Serializable {
    /**
     * Default serial version id
     */


    /**
     * Unique identifier.
     */
    private Long id = null;

    /**
     * Simple plain constructor
     */
    public DomainObject() {
        id = null;
    }

    /**
     * Constructor that sets the id parameter
     *
     * @param id Id of the object to set
     */
    public DomainObject(Long id) {
        this.id = id;
    }

    /**
     * <p>
     * Constructor that initialized <code>this</code> object with values of the
     * passed object.
     * </p>
     * <p>
     * The method {@link #copyFieldsValuesFrom(DomainObject)} is used.
     * </p>
     * <p>
     * Objects should be of the same class!
     * </p>
     *
     * @param obj Another object to get values from
     */
    public DomainObject(DomainObject obj) {
        id = null;
        copyFieldsValuesFrom(obj);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <p>
     * Copying all properties of the passed <code>obj</code> object to
     * <code>this</code> object.
     * </p>
     * <p>
     * The property {@link #id} is not copied. Also all properties that extend
     * {@link Collection} and {@link Class} are not copied either.
     * </p>
     *
     * @param obj Object to get values from
     */
    @SuppressWarnings("unchecked")
    public void copyFieldsValuesFrom(DomainObject obj) {
        if ((obj != null) && (this.getClass().isAssignableFrom(obj.getClass()))) {

            try {
                Map<String, Object> props = PropertyUtils.describe(obj);

                for (Entry<String, Object> entry : props.entrySet()) {
                    if (PropertyUtils.isWriteable(this, entry.getKey())) {
                        Class<?> clazz = PropertyUtils.getPropertyType(obj,
                                entry.getKey());
                        if ((!Collection.class.isAssignableFrom(clazz))
                                && (!clazz.isAssignableFrom(Class.class))
                                && (!entry.getKey().equals("id"))) { //$NON-NLS-1$
                            PropertyUtils.setProperty(this, entry.getKey(),
                                    entry.getValue());
                        }
                    }
                }

            } catch (Exception e) {
                Log log = LogFactory.getLog(getClass());
                log.error(String.format("Failed to copy all field values from <%s> to <%s>", this.toString(), obj.toString()), e);
            }

        }
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.Object#equals(java.lang.Object)
      */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DomainObject other = (DomainObject) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /*
      * (non-Javadoc)
      *
      * @see java.lang.Object#toString()
      */
    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this,
                ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }

}
