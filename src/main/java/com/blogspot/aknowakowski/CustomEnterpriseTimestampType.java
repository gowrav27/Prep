package com.blogspot.aknowakowski;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.DateType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.ParameterizedType;

public class CustomEnterpriseTimestampType implements ParameterizedType, CompositeUserType
{
    /**
     * Represents "1800-01-01T00:00:00.000000000" as the default beginning of time.
     */
    private String BOT = "1800-01-01T00:00:00.000000000";

    /**
     * Represents "2100-12-31T00:00:00.000000000" as the default end of time.
     */
    private String EOT = "2100-12-31T00:00:00.000000000";

    private static final TimestampType TIMESTAMP = new TimestampType();
    private static final DateType DATETYPE = new DateType();

    private static final String[] PROPERTY_NAMES = new String[] {"javaDate", ""};

    public String[] getPropertyNames()
    {
        // TODO Auto-generated method stub
        return new String[] {""};
    }

    public Type[] getPropertyTypes()
    {
        return new Type[] {DATETYPE.INSTANCE};
    }

    public Object getPropertyValue(Object component, int property) throws HibernateException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void setPropertyValue(Object component, int property, Object value) throws HibernateException
    {
        // TODO Auto-generated method stub

    }

    public Class returnedClass()
    {
        return Timestamp.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException
    {
        if(x == y)
        {
            return true;
        }

        return (x == null ? false : x.equals(y));
    }

    public int hashCode(Object x) throws HibernateException
    {
        return x == null ? 17 : x.hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException
    {
        st.setDate(index, new java.sql.Date(System.currentTimeMillis() + 86400000));
    }

    public Object deepCopy(Object value) throws HibernateException
    {
        if(value == null)
        {
            return null;
        }

        if(value instanceof Timestamp)
        {
            Timestamp orig = (Timestamp) value;
            Timestamp ts = new Timestamp(orig.getTime());
            ts.setNanos(orig.getNanos());
            return ts;
        }
        else
        {
            Date orig = (Date) value;
            return new Date(orig.getTime());
        }
    }

    public boolean isMutable()
    {
        return true;
    }

    public Serializable disassemble(Object value, SessionImplementor session) throws HibernateException
    {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, SessionImplementor session, Object owner) throws HibernateException
    {
        return cached;
    }

    public Object replace(Object original, Object target, SessionImplementor session, Object owner) throws HibernateException
    {
        if(equals(original, target))
        {
            return original;
        }
        return deepCopy(original);
    }

    public void setParameterValues(Properties parameters)
    {
        if(parameters != null)
        {
            BOT = parameters.getProperty("BOT", BOT);
            EOT = parameters.getProperty("EOT", EOT);
        }
    }
}
