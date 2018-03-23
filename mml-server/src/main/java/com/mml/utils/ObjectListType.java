package com.mml.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
* 自定义List<Object> - hibernate
* @author liwenbing
* @create 2018/1/2/002 16:10
**/
public class ObjectListType implements UserType,Serializable {

    private static final char SPLITER=';';
    private static int[] TYPES = new int[]{Types.VARCHAR};//对应数据库中的类型
    private static Class RETURN_CLASS = List.class;
    @Override
    public int[] sqlTypes() {
        return TYPES;
    }

    /**
     * 修改类型对应的java类型
     * 我们这边使用LIST类型
     * @return
     */
    @Override
    public Class returnedClass() {
        return RETURN_CLASS;
    }

    /**
     * 自定义数据类型比对方法
     * @param x
     * @param y
     * @return
     * @throws HibernateException
     */
    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x==y) {
            return true;
        }
        if(x!=null&&y!=null){
            List xList=(List)x;
            List ylList=(List)y;
            if (xList.size()!=ylList.size()) {
                return false;
            }
            for(int i=0;i<xList.size();i++){
                String s1=(String)xList.get(i);
                String s2=(String)ylList.get(i);
                if (!s1.equals(s2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {
        //取得字段名称并查询
        String s = (String) resultSet.getObject(strings[0]);

        List temp=new ArrayList<String>();
        if(resultSet.wasNull())
        {
            return null;
        }
        else
        {
            String[] strs=s.split(";");
            for(int i=0;i<strs.length;i++)
            {
                temp.add(strs[i]);
            }
            return temp;
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        if(o!=null){
            String str=combain((List)o);
            //保存数据
            preparedStatement.setString(i, str);
        }else {
            //空值就直接保存了
            preparedStatement.setNull(i, Types.VARCHAR);
        }
    }

    private String combain(List list){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<list.size()-1;i++){
            sb.append(list.get(i)).append(SPLITER);
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }

    /**
     * 自定义类型的完全复制方法,构造返回对象
     *    1. 当nullSafeGet方法调用之后，我们获得了自定义数据对象，在向用户返回自定义数据之前
     * deepCopy方法被调用，它将根据自定义数据对象构造一个完全拷贝，把拷贝返还给客户使用。
     *    2.此时我们就得到了自定义数据对象的两个版本
     *     原始版本由hibernate维护，用作脏数据检查依据，复制版本由用户使用，hibernate将在
     * 脏数据检查过程中比较这两个版本的数据。
     * @param o
     * @return
     * @throws HibernateException
     */
    @Override
    public Object deepCopy(Object o) throws HibernateException {
        List source=(List)o;
        List target=new ArrayList();
        target.addAll(source);
        return target;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable)deepCopy(o);
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return deepCopy(serializable);
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return deepCopy(o);
    }
}
