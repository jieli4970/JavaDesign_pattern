package SingleTon;

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

//����ʽ�����࣬�ڵ�һ�ε��õ�ʱ��ʵ�����Լ�
class SingleTon{
	private SingleTon() {};
	private static SingleTon singleTon=null;
//	��̬��������
	public static SingleTon getInstance() {
		if (singleTon == null) {
			singleTon = new SingleTon();
		}
		return singleTon;
	}

}
