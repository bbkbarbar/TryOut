import hu.barbar.util.Env;

public class Test2 {
	
	public static Test2 me = null;

	public static void main(String[] args) {
		me = new Test2();
		me.doIt();
	}

	public Test2(){}

	private void doIt(){
		show(System.getProperty("os.name"));
		show("\n");
		show("Data folder:\n|"+Env.getDataFolderPath() + "|");
		
		Env.guaranteeDataFolderExists();
	}
	
	
	private void show(String s){
		System.out.println(s);
	}
	
}
