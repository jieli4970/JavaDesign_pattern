package singletom;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jieli
 *
 * 2018年6月7日
 */

/**
 * 三种单例模式
 * 1、懒汉式
 * 2、饿汉式
 * 3、登记式
 *	
 * 单例模式特点
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例
 * 3、单例类必须给所有其他对象提供这一实例
 * 
 */


public class SingleTom {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		SingleTon singleTon = SingleTon.getInstance();
		Constructor con = SingleTon.class.getDeclaredConstructor();  
		
		//默认不能访问private权限的构造方法，设为true，则可以访问 newinstance
		con.setAccessible(true);  
		SingleTon singetonTest1 = (SingleTon)con.newInstance();  
		SingleTon singetonTest2 = (SingleTon)con.newInstance();  		
		System.out.println(singleTon+"    "+ singetonTest1+"   "+singetonTest2);

		
		
		SingleSafe singleSafe = SingleSafe.getInstance();
		Constructor constructor = singleSafe.getClass().getConstructor();
		
		constructor.setAccessible(true);
		SingleSafe singleSafe2=(SingleSafe) constructor.newInstance();
		SingleSafe singleSafe3=(SingleSafe) constructor.newInstance();
		
		System.out.println(singleSafe2);
		System.out.println(singleSafe3);

	}

}

//懒汉式单例类，在第一次调用的时候实例化自己
//可以通过反射模式破坏单例
class SingleTon{
	private SingleTon() {};
	private static SingleTon singleTon=null;
//	静态工厂方法
	public static  SingleTon getInstance() {
		if (singleTon == null) {
			singleTon = new SingleTon();
		}
		return singleTon;
	}

}

//防止反射破快单例

//懒汉式单例类，在第一次调用的时候实例化自己
class SingleSafe{
	private static boolean flag = true;
	private SingleSafe() {
		if (flag) {
			flag = !flag;
			System.out.println(1111);
		}else {
			 try {  
	                throw new Exception("duplicate instance create error!" + SingleSafe.class.getName());  
	            } catch (Exception e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            } 
		}
		
	};
	private static SingleSafe singleSafe=null;
//	静态工厂方法
	public static  SingleSafe getInstance() {
		if (singleSafe == null) {
			singleSafe = new SingleSafe();
		}
		return singleSafe;
	}

}
