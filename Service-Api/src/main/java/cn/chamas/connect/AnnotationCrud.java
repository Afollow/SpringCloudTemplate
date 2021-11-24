package cn.chamas.connect;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;

@Service
public class AnnotationCrud {
    private InputStream inputStream;

    public SqlSession init() throws IOException {
        inputStream = Resources.getResourceAsStream("sql-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        return session;
    }

    public void destroy(SqlSession session) throws IOException {
        session.commit();
        session.close();
        inputStream.close();
    }
}
