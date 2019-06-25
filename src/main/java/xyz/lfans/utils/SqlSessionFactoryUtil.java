package xyz.lfans.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Atlantis
 * @create 2019-06-21-14:16
 */

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static final Class<SqlSessionFactoryUtil> CLASS_LOCK = SqlSessionFactoryUtil.class;

    /**
     * 私有化构造
     */
    private SqlSessionFactoryUtil(){
    }
    /*
     * 单实例对象
     */
    public static SqlSessionFactory initSqlSessionFactory()  {
        synchronized (CLASS_LOCK){
            if(sqlSessionFactory != null){
                return sqlSessionFactory;
            }
            String resource = "conf/mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession() throws IOException {
        if (sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

}
