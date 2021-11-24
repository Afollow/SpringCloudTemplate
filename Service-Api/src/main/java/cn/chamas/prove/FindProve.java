package cn.chamas.prove;

import cn.chamas.connect.AnnotationCrud;
import cn.chamas.dao.FindDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class FindProve extends FindService {
    @Autowired
    AnnotationCrud annotationCrud;

//    @Override
//    public List<$> $() throws IOException {
//        SqlSession session = annotationCrud.init();
//        FindDao mapper = session.getMapper(FindDao.class);
//        List<$> $ = mapper.$();
//        annotationCrud.destroy(session);
//        return $;
//    }
//    @Override
//    public $ $($ $) throws IOException {
//        SqlSession session = annotationCrud.init();
//        FindDao mapper = session.getMapper(FindDao.class);
//        $ $ = mapper.$($);
//        annotationCrud.destroy(session);
//        return $;
//    }
}
