package SingleTon;

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
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleTon singleTon = SingleTon.getInstance();
		
		System.out.println(singleTon);
		System.out.println(singleTon.getInstance());
		
		Class tmp = singleTon.getInstance().getClass();
		
		Method[] method= tmp.getMethods();
		for (int i = 0; i < method.length; i++) {
			Method method2=method[i];
			System.out.println("name"+method2.getName());
			if (method2.getName().equals("getInstance")) {
				System.out.println(method2.invoke(tmp));
			}
			
			
		}
		
	}

}

//懒汉式单例类，在第一次调用的时候实例化自己
class SingleTon{
	private SingleTon() {};
	private static SingleTon singleTon=null;
//	静态工厂方法
	public static SingleTon getInstance() {
		if (singleTon == null) {
			singleTon = new SingleTon();
		}
		return singleTon;
	}

}
