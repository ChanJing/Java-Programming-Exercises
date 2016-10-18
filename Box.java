import java.io.*;	//必须要import

public class Box implements Serializable{
	//没有方法需要被实现,只是用来告诉Java虚拟机它可以被序列化
	private int width;
	private int height;

	public void setWidth(int w){
		width = w;
	}
	public void setHeight(int h){
		height = h;
	}

	public static void main(String[] args){
		Box myBox = new Box();
		myBox.setWidth(50);
		myBox.setHeight(20);

		try{
			FileOutputStream fs = new FileOutputStream("foo.ser");
			//设定连接
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}