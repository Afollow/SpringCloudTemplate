package cn.chamas.prove;

import cn.chamas.connect.AnnotationCrud;
import cn.chamas.dao.FindDao;
import cn.chamas.domain.ControllerUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class FindProve extends FindService {
    @Autowired
    AnnotationCrud annotationCrud;

    @Override
    public List<ControllerUser> userByAll() throws IOException {
        SqlSession session = annotationCrud.init();
        FindDao mapper = session.getMapper(FindDao.class);
        List<ControllerUser> controllerUser = mapper.userByAll();
        annotationCrud.destroy(session);
        return controllerUser;
    }
    @Override
    public List<ControllerUser> userByAppoint(ControllerUser controllerUser) throws IOException {
        SqlSession session = annotationCrud.init();
        FindDao mapper = session.getMapper(FindDao.class);
        List<ControllerUser> controllerUsers = mapper.userByAppoint(controllerUser);
        annotationCrud.destroy(session);
        return controllerUsers;
    }
    @Override
    public ControllerUser userByAppointOne(ControllerUser controllerUser) throws IOException {
        SqlSession session = annotationCrud.init();
        FindDao mapper = session.getMapper(FindDao.class);
        ControllerUser newControllerUser = mapper.userByAppointOne(controllerUser);
        annotationCrud.destroy(session);
        return newControllerUser;
    }
}
