package demo1;
/*
 *一、通过三种方法获得Class对象：
 *1.Class c1 = Code.class;//类的静态成员变量
 *2.Class c2 = code1.getClass();//对象的getClass()方法
 *3.Class c3 = Class.forName("com.trigl.reflect.Code");
 *******Class类调用forName方法。通过一个雷的全量限定名获得
 *
 *二、通过获取的Class进行操作
 *1.获取成员方法Method
 *2.获取成员变量Field
 *3.获取构造函数Constructor
 *		获取成员方法信息：public Method getDeclaredMethod(String name,Class<?>...paramsTypes)
 *					得到该类的所有方法，不包括父类的
 *				public Method getMethod(String name,Class<?>...paramsTypes)
 *					得到该类的所有public方法，包括父类的
 *				两个参数是：方法名和参数列表类型
 *		获取成员变量信息：public Field getDeclaredField(String name)
 *					得到该类自身声明的所有变量，不包括父类的变量
 *				public Filed getField(String name)
 *					得到所有的public成员变量，包括其父类的变量
 *				参数是      变量名。
 *		获取构造函数：public Constructor<T> getDeclaredConstructor(Class<?>...paramsTypes)
 *					获得所有构造函数，不包括父类的
 *				public Constructor<T> getConstructor(Class<?> paramsTypes)
 *					获得所有public构造函数，包括父类
 *
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo1.Person;

public class ReflectDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException{
		
		try {
			//第一种
			Class class1 = ReflectDemo1.class;
			System.out.println(class1.getName());
			
			//第二种
			ReflectDemo1 demo2 = new ReflectDemo1();
			Class c2 = demo2.getClass();
			System.out.println(c2.getName());
			
			//第三种
			Class class3 = Class.forName("demo1.ReflectDemo1");
			System.out.println(class3.getName());
			
			
			Class c = Class.forName("demo1.Person");//生成class
			Object o = c.newInstance();//初始化一个实例
			@SuppressWarnings("unchecked")
			Method method = c.getMethod("fun", String.class ,int.class);//获取方法
			method.invoke(o, "tengj",10);//通过invoke()函数调用该方法，第一个参数是实例对象，后面参数值
			
			/*获取所有方法*/
			Method[] methods1 = c.getDeclaredMethods();//得到该类的所有方法，不包括父类
			Method[] methods2 = c.getMethods();//所有public方法。包括父类
			/*
			for(Method m:methods1){
				System.out.println(m.getName());
			}
			for(Method m:methods2){
				System.out.println(m.getName());
			}
			*/
			
			Field field = c.getDeclaredField("msg");//获取成员变量
			Object o1 = c.newInstance();
			field.setAccessible(true);//设置成允许访问
			Object msg = field.get(o1);
			System.out.println(msg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
