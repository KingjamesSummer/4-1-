import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import entity.User;
import mapper.IUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

public class TestCRUD1 {
    @Test
    public void testAdd() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            User user = new User();
            user.setUsername("ab");
            user.setRealname("小A");
            user.setMoblie("110");
            user.setPassword("1111");
            user.setAge(18);
            IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
            int i = mapper.addUser(user);
            if (i > 0) {
                System.out.println("添加成功1");
            } else {
                System.out.println("添加失败1");
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败2");
            sqlSession.rollback();
        } finally {
            testGetAllUser();
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
            List<User> users = mapper.getAllUsers();
            for (User u : users) {
                System.out.println(u);
            }
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetuser() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
            User user = mapper.getUserById("www");
            if (user != null) {
                System.out.println(user);
            } else {
                System.out.println("查无此人");            }
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetOneUser() {
        SqlSession sqlSession = null;
        try {
            SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
            IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
            User user = mapper.getUserByUsernameAndPassword("Lisi", "222");
            if (user != null) {
                System.out.println(user);
            } else {
                System.out.println("查无此人");
            }
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testUserWithPaing() {
        int pageSize = 1;
        int pageNum = 1;
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = MyBatisUtil.getSqlSession().getMapper(IUserMapper.class).getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("每页记录数"+pageInfo.getPageSize());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("当前页记录数"+pageInfo.getSize());
        for (User user:pageInfo.getList()){
            System.out.println(user);
        }

    }
}
