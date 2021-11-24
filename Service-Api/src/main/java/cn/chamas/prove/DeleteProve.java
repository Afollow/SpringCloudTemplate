package cn.chamas.prove;

import cn.chamas.connect.AnnotationCrud;
import cn.chamas.dao.DeleteDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class DeleteProve extends DeleteService{
    @Autowired
    AnnotationCrud annotationCrud;

//    @Override
//    public void $($ $) throws IOException {
//        SqlSession session = annotationCrud.init();
//        DeleteDao mapper = session.getMapper(DeleteDao.class);
//        mapper.$($);
//        annotationCrud.destroy(session);
//    }
}
