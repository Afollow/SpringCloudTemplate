package cn.chamas.prove;

import cn.chamas.connect.AnnotationCrud;
import cn.chamas.dao.InsertDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InsertProve extends InsertService{
    @Autowired
    AnnotationCrud annotationCrud;

//    @Override
//    public void $($ $) throws IOException {
//        SqlSession session = annotationCrud.init();
//        InsertDao mapper = session.getMapper(InsertDao.class);
//        mapper.$($);
//        annotationCrud.destroy(session);
//    }
}
