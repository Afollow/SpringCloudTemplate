package cn.chamas.prove;

import cn.chamas.connect.AnnotationCrud;
import cn.chamas.dao.UpdateDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class UpdateProve extends UpdateService{
    @Autowired
    AnnotationCrud annotationCrud;

//    @Override
//    public void $($ $) throws IOException {
//        SqlSession session = annotationCrud.init();
//        UpdateDao mapper = session.getMapper(UpdateDao.class);
//        mapper.$($);
//        annotationCrud.destroy(session);
//    }
}
