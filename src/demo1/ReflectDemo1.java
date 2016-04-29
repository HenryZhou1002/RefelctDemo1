package demo1;
/*
 *һ��ͨ�����ַ������Class����
 *1.Class c1 = Code.class;//��ľ�̬��Ա����
 *2.Class c2 = code1.getClass();//�����getClass()����
 *3.Class c3 = Class.forName("com.trigl.reflect.Code");
 *******Class�����forName������ͨ��һ���׵�ȫ���޶������
 *
 *����ͨ����ȡ��Class���в���
 *1.��ȡ��Ա����Method
 *2.��ȡ��Ա����Field
 *3.��ȡ���캯��Constructor
 *		��ȡ��Ա������Ϣ��public Method getDeclaredMethod(String name,Class<?>...paramsTypes)
 *					�õ���������з����������������
 *				public Method getMethod(String name,Class<?>...paramsTypes)
 *					�õ����������public���������������
 *				���������ǣ��������Ͳ����б�����
 *		��ȡ��Ա������Ϣ��public Field getDeclaredField(String name)
 *					�õ������������������б���������������ı���
 *				public Filed getField(String name)
 *					�õ����е�public��Ա�����������丸��ı���
 *				������      ��������
 *		��ȡ���캯����public Constructor<T> getDeclaredConstructor(Class<?>...paramsTypes)
 *					������й��캯���������������
 *				public Constructor<T> getConstructor(Class<?> paramsTypes)
 *					�������public���캯������������
 *
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import demo1.Person;

public class ReflectDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException{
		
		try {
			//��һ��
			Class class1 = ReflectDemo1.class;
			System.out.println(class1.getName());
			
			//�ڶ���
			ReflectDemo1 demo2 = new ReflectDemo1();
			Class c2 = demo2.getClass();
			System.out.println(c2.getName());
			
			//������
			Class class3 = Class.forName("demo1.ReflectDemo1");
			System.out.println(class3.getName());
			
			
			Class c = Class.forName("demo1.Person");//����class
			Object o = c.newInstance();//��ʼ��һ��ʵ��
			@SuppressWarnings("unchecked")
			Method method = c.getMethod("fun", String.class ,int.class);//��ȡ����
			method.invoke(o, "tengj",10);//ͨ��invoke()�������ø÷�������һ��������ʵ�����󣬺������ֵ
			
			/*��ȡ���з���*/
			Method[] methods1 = c.getDeclaredMethods();//�õ���������з���������������
			Method[] methods2 = c.getMethods();//����public��������������
			/*
			for(Method m:methods1){
				System.out.println(m.getName());
			}
			for(Method m:methods2){
				System.out.println(m.getName());
			}
			*/
			
			Field field = c.getDeclaredField("msg");//��ȡ��Ա����
			Object o1 = c.newInstance();
			field.setAccessible(true);//���ó��������
			Object msg = field.get(o1);
			System.out.println(msg);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
