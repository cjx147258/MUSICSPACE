package space.service;

import space.bean.User;
import space.dao.UserDao;

public class regService {
		 //声明并创建UserDao对象

		
		public static User getUserByCond(String name, String password) {
			// TODO Auto-generated method stub
			return UserDao.getUserByCond(name, password);
		}

		
		public static int regUser(String name, String info, String password, String icon_url, String gender) {
			//先查询用户是否存在
			User user=UserDao.getUserByName(name);
			if(user!=null) {
				return -1;			//代表用户存在，无法注册
			}else {			//代表用户不存在，可以注册
			  int result=UserDao.addUser(name, info, password, icon_url, gender);
			  return result;		//返回注册的结果
			}
		}
		
		public static User getUserByName(String name) {
			// TODO Auto-generated method stub
			return UserDao.getUserByName(name);
		}

	
}
