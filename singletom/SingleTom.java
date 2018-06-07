package singletom;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jieli
 *
 * 2018��6��7��
 */

/**
 * ���ֵ���ģʽ
 * 1������ʽ
 * 2������ʽ
 * 3���Ǽ�ʽ
 *	
 * ����ģʽ�ص�
 * 1��������ֻ����һ��ʵ����
 * 2������������Լ������Լ���Ψһʵ��
 * 3�������������������������ṩ��һʵ��
 * 
 */


public class SingleTom {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		SingleTon singleTon = SingleTon.getInstance();
		Constructor con = SingleTon.class.getDeclaredConstructor();  
		
		//Ĭ�ϲ��ܷ���privateȨ�޵Ĺ��췽������Ϊtrue������Է��� newinstance
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

//����ʽ�����࣬�ڵ�һ�ε��õ�ʱ��ʵ�����Լ�
//����ͨ������ģʽ�ƻ�����
class SingleTon{
	private SingleTon() {};
	private static SingleTon singleTon=null;
//	��̬��������
	public static  SingleTon getInstance() {
		if (singleTon == null) {
			singleTon = new SingleTon();
		}
		return singleTon;
	}

}

//��ֹ�����ƿ쵥��

//����ʽ�����࣬�ڵ�һ�ε��õ�ʱ��ʵ�����Լ�
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
//	��̬��������
	public static  SingleSafe getInstance() {
		if (singleSafe == null) {
			singleSafe = new SingleSafe();
		}
		return singleSafe;
	}

}
