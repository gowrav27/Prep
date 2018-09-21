package com.blogspot.aknowakowski;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.TimestampType;
import org.hibernate.usertype.UserType;

public class EnterpriseTimestampType implements UserType
{
    // TODO StandardBasicTypes.TIMESTAMP should be used instead when assemblies are using Hibernate
    // 4 and beyond
    private static final TimestampType TIMESTAMP = new TimestampType();

    public int[] sqlTypes()
    {
        return new int[] {TIMESTAMP.sqlType()};
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
        // TODO Auto-generated method stub
        return x == null ? 17 : x.hashCode();
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

    public Serializable disassemble(Object value) throws HibernateException
    {
        return (Serializable) value;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException
    {
        return cached;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException
    {
        if(equals(original, target))
        {
            return original;
        }
        return deepCopy(original);
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException
    {
        st.setDate(1, new java.sql.Date(System.currentTimeMillis() + 86400000));
    }
}
