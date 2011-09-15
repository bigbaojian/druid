package com.alibaba.druid.bvt.pool.basic;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.SQLXML;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.mock.MockResultSet;
import com.alibaba.druid.pool.PoolableResultSet;
import com.alibaba.druid.pool.PoolableStatement;

public class ResultSetTest extends TestCase {

    private PoolableStatement stmt;
    private MockResultSet     raw;
    private PoolableResultSet resultSet;

    protected void setUp() throws Exception {
        stmt = new PoolableStatement(null, null) {

            protected SQLException checkException(Throwable error) throws SQLException {
                if (error instanceof SQLException) {
                    return (SQLException) error;
                }

                return new SQLException(error);
            }
        };

        raw = new MockResultSet(null);
        raw.getRows().add(new Object[] { null });
        resultSet = new PoolableResultSet(stmt, raw);
    }

    @SuppressWarnings("deprecation")
    public void test_get() throws Exception {

        Assert.assertTrue(stmt == resultSet.getPoolableStatement());
        Assert.assertTrue(raw == resultSet.getRawResultSet());

        Assert.assertTrue(resultSet.next());
        Assert.assertTrue(resultSet.wasNull() == false);
        resultSet.getString(1);
        Assert.assertTrue(resultSet.wasNull());
        resultSet.getBoolean(1);
        resultSet.getByte(1);
        resultSet.getShort(1);
        resultSet.getInt(1);
        resultSet.getLong(1);
        resultSet.getFloat(1);
        resultSet.getDouble(1);
        resultSet.getBigDecimal(1);
        resultSet.getBigDecimal(1, 1);
        resultSet.getBytes(1);
        resultSet.getDate(1);
        resultSet.getTime(1);
        resultSet.getTimestamp(1);
        resultSet.getAsciiStream(1);
        resultSet.getUnicodeStream(1);
        resultSet.getBinaryStream(1);

        resultSet.getString("1");
        resultSet.getBoolean("1");
        resultSet.getByte("1");
        resultSet.getShort("1");
        resultSet.getInt("1");
        resultSet.getLong("1");
        resultSet.getFloat("1");
        resultSet.getDouble("1");
        resultSet.getBigDecimal("1");
        resultSet.getBigDecimal("1", 1);
        resultSet.getBytes("1");
        resultSet.getDate("1");
        resultSet.getTime("1");
        resultSet.getTimestamp("1");
        resultSet.getAsciiStream("1");
        resultSet.getUnicodeStream("1");
        resultSet.getBinaryStream("1");

    }

    public void test_set() throws Exception {
        long currentMillis = System.currentTimeMillis();

        Assert.assertTrue(resultSet.next());

        resultSet.updateNull(1);
        Assert.assertNull(resultSet.getString(1));
        resultSet.updateBoolean(1, true);
        Assert.assertEquals(true, resultSet.getBoolean(1));

        resultSet.updateByte(1, (byte) 12);
        Assert.assertEquals(12, resultSet.getByte(1));

        resultSet.updateShort(1, (short) 23);
        Assert.assertEquals(23, resultSet.getShort(1));

        resultSet.updateInt(1, 34);
        Assert.assertEquals(34, resultSet.getInt(1));

        resultSet.updateLong(1, 45);
        Assert.assertEquals(45, resultSet.getLong(1));

        resultSet.updateFloat(1, 1.0F);
        Assert.assertEquals(true, 1.0F == resultSet.getFloat(1));

        resultSet.updateDouble(1, 2.0D);
        Assert.assertEquals(true, 2.0D == resultSet.getDouble(1));

        resultSet.updateBigDecimal(1, new BigDecimal("33"));
        Assert.assertEquals(new BigDecimal("33"), resultSet.getBigDecimal(1));

        resultSet.updateString(1, "xxx");
        Assert.assertEquals("xxx", resultSet.getString(1));

        resultSet.updateBytes(1, new byte[0]);
        Assert.assertEquals(0, resultSet.getBytes(1).length);

        resultSet.updateDate(1, new java.sql.Date(currentMillis));
        Assert.assertEquals(new java.sql.Date(currentMillis), resultSet.getDate(1));

        resultSet.updateTime(1, new java.sql.Time(1000));
        Assert.assertEquals(new java.sql.Time(1000), resultSet.getTime(1));

        resultSet.updateTimestamp(1, new java.sql.Timestamp(currentMillis));
        Assert.assertEquals(new java.sql.Timestamp(currentMillis), resultSet.getTimestamp(1));
    }

    public void test_set_error() throws Exception {
        long currentMillis = System.currentTimeMillis();

        Assert.assertTrue(resultSet.next());

        {
            SQLException error = null;
            try {
                resultSet.updateNull(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateBoolean(0, true);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateByte(0, (byte) 12);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateShort(0, (short) 23);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateInt(0, 34);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateLong(0, 45);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateFloat(0, 1.0F);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateDouble(0, 2.0D);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateBigDecimal(0, new BigDecimal("33"));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateString(0, "xxx");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateBytes(0, new byte[0]);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateDate(0, new java.sql.Date(currentMillis));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateTime(0, new java.sql.Time(1000));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateTimestamp(0, new java.sql.Timestamp(currentMillis));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

    }

    public void test_setByName() throws Exception {
        long currentMillis = System.currentTimeMillis();

        Assert.assertTrue(resultSet.next());

        resultSet.updateNull("1");
        Assert.assertNull(resultSet.getString(1));
        resultSet.updateBoolean("1", true);
        Assert.assertEquals(true, resultSet.getBoolean("1"));

        resultSet.updateByte("1", (byte) 12);
        Assert.assertEquals(12, resultSet.getByte("1"));

        resultSet.updateShort("1", (short) 23);
        Assert.assertEquals(23, resultSet.getShort("1"));

        resultSet.updateInt("1", 34);
        Assert.assertEquals(34, resultSet.getInt("1"));

        resultSet.updateLong("1", 45);
        Assert.assertEquals(45, resultSet.getLong("1"));

        resultSet.updateFloat("1", 1.0F);
        Assert.assertEquals(true, 1.0F == resultSet.getFloat("1"));

        resultSet.updateDouble("1", 2.0D);
        Assert.assertEquals(true, 2.0D == resultSet.getDouble("1"));

        resultSet.updateBigDecimal("1", new BigDecimal("33"));
        Assert.assertEquals(new BigDecimal("33"), resultSet.getBigDecimal("1"));

        resultSet.updateString("1", "xxx");
        Assert.assertEquals("xxx", resultSet.getString("1"));

        resultSet.updateBytes("1", new byte[0]);
        Assert.assertEquals(0, resultSet.getBytes("1").length);

        resultSet.updateDate("1", new java.sql.Date(currentMillis));
        Assert.assertEquals(new java.sql.Date(currentMillis), resultSet.getDate("1"));

        resultSet.updateTime("1", new java.sql.Time(1000));
        Assert.assertEquals(new java.sql.Time(1000), resultSet.getTime("1"));

        resultSet.updateTimestamp("1", new java.sql.Timestamp(currentMillis));
        Assert.assertEquals(new java.sql.Timestamp(currentMillis), resultSet.getTimestamp("1"));
    }

    public void test_updateByLabel_error() throws Exception {
        long currentMillis = System.currentTimeMillis();

        Assert.assertTrue(resultSet.next());

        {
            SQLException error = null;
            try {
                resultSet.updateNull("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateBoolean("0", true);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateByte("0", (byte) 12);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateShort("0", (short) 23);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateInt("0", 34);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateLong("0", 45);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateFloat("0", 1.0F);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateDouble("0", 2.0D);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateBigDecimal("0", new BigDecimal("33"));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateString("0", "xxx");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateBytes("0", new byte[0]);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateDate("0", new java.sql.Date(currentMillis));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateTime("0", new java.sql.Time(1000));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.updateTimestamp("0", new java.sql.Timestamp(currentMillis));
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

    }
    
    public void test_updateBinaryStream() throws Exception {
        resultSet.next();
        
        resultSet.updateBinaryStream(1, (InputStream) null);
        resultSet.updateBinaryStream("1", (InputStream) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateBinaryStream("0", (InputStream) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateBinaryStream(0, (InputStream) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_updateCharacterStream() throws Exception {
        resultSet.next();
        
        resultSet.updateCharacterStream(1, (Reader) null);
        resultSet.updateCharacterStream("1", (Reader) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateCharacterStream("0", (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateCharacterStream(0, (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_update_blob() throws Exception {
        resultSet.next();
        
        resultSet.updateBlob(1, (InputStream) null);
        resultSet.updateBlob("1", (InputStream) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateBlob("0", (InputStream) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateBlob(0, (InputStream) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }

    public void test_update_clob() throws Exception {
        resultSet.next();
        
        resultSet.updateClob(1, (Reader) null);
        resultSet.updateClob("1", (Reader) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateClob("0", (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateClob(0, (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_update_nclob() throws Exception {
        resultSet.next();
        
        resultSet.updateNClob(1, (Reader) null);
        resultSet.updateNClob("1", (Reader) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateNClob("0", (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateNClob(0, (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_update_nclob_1() throws Exception {
        resultSet.next();
        
        resultSet.updateNClob(1, (Reader) null, 1);
        resultSet.updateNClob("1", (Reader) null, 1);
        
        {
            SQLException error = null;
            try {
                resultSet.updateNClob("0", (Reader) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateNClob(0, (Reader) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_update_clob_1() throws Exception {
        resultSet.next();
        
        resultSet.updateClob(1, (Reader) null, 1);
        resultSet.updateClob("1", (Reader) null, 1);
        
        {
            SQLException error = null;
            try {
                resultSet.updateClob("0", (Reader) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateClob(0, (Reader) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_update_blob_1() throws Exception {
        resultSet.next();
        
        resultSet.updateBlob(1, (InputStream) null, 1);
        resultSet.updateBlob("1", (InputStream) null, 1);
        
        {
            SQLException error = null;
            try {
                resultSet.updateBlob("0", (InputStream) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateBlob(0, (InputStream) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_updateCharacterStream_1() throws Exception {
        resultSet.next();
        
        resultSet.updateCharacterStream(1, (Reader) null, 1);
        resultSet.updateCharacterStream("1", (Reader) null, 1);
        
        {
            SQLException error = null;
            try {
                resultSet.updateCharacterStream("0", (Reader) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateCharacterStream(0, (Reader) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_updateAsciiStream_1() throws Exception {
        resultSet.next();
        
        resultSet.updateAsciiStream(1, (InputStream) null, 1);
        resultSet.updateAsciiStream("1", (InputStream) null, 1);
        
        {
            SQLException error = null;
            try {
                resultSet.updateAsciiStream("0", (InputStream) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateBlob(0, (InputStream) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    
    public void test_updateBinaryStream_1() throws Exception {
        resultSet.next();
        
        resultSet.updateBinaryStream(1, (InputStream) null, 1);
        resultSet.updateBinaryStream("1", (InputStream) null, 1);
        
        {
            SQLException error = null;
            try {
                resultSet.updateBinaryStream("0", (InputStream) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateBinaryStream(0, (InputStream) null, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_updateAsciiStream() throws Exception {
        resultSet.next();
        
        resultSet.updateAsciiStream(1, (InputStream) null);
        resultSet.updateAsciiStream("1", (InputStream) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateAsciiStream("0", (InputStream) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateAsciiStream(0, (InputStream) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_updateNCharacterStream() throws Exception {
        resultSet.next();
        
        resultSet.updateNCharacterStream(1, (Reader) null);
        resultSet.updateNCharacterStream("1", (Reader) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateNCharacterStream("0", (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateNCharacterStream(0, (Reader) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
    
    public void test_updateSQLXML() throws Exception {
        resultSet.next();
        
        resultSet.updateSQLXML(1, (SQLXML) null);
        resultSet.updateSQLXML("1", (SQLXML) null);
        
        {
            SQLException error = null;
            try {
                resultSet.updateSQLXML("0", (SQLXML) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
        
        {
            SQLException error = null;
            try {
                resultSet.updateSQLXML(0, (SQLXML) null);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }

    public void test_get_error() throws Exception {
        {
            SQLException error = null;
            try {
                resultSet.getString(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBoolean(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getByte(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getShort(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getInt(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getLong(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getFloat(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getDouble(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBigDecimal(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBigDecimal(0, 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBytes(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getDate(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getTime(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getTimestamp(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getAsciiStream(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getUnicodeStream(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBinaryStream(0);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        // ////////////////

        {
            SQLException error = null;
            try {
                resultSet.getString("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBoolean("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getByte("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getShort("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getInt("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getLong("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getFloat("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getDouble("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBigDecimal("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBigDecimal("0", 1);
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBytes("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getDate("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getTime("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getTimestamp("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getAsciiStream("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getUnicodeStream("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }

        {
            SQLException error = null;
            try {
                resultSet.getBinaryStream("0");
            } catch (SQLException ex) {
                error = ex;
            }
            Assert.assertNotNull(error);
        }
    }
}
