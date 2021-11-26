package cn.chamas.prove;

import cn.chamas.connect.AnnotationCrud;
import cn.chamas.dao.InsertDao;
import cn.chamas.domain.ControllerUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class InsertProve extends InsertService{
    @Autowired
    AnnotationCrud annotationCrud;

    @Override
    public void user(ControllerUser controllerUser) throws IOException {
        SqlSession session = annotationCrud.init();
        InsertDao mapper = session.getMapper(InsertDao.class);
        mapper.user(controllerUser);
        annotationCrud.destroy(session);
    }
}
