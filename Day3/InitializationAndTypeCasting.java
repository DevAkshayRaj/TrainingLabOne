package first_session;

public class InitializationAndTypeCasting {
	public static void main(String[] args) {
		int v1=1;
		char v2='a';
		String v3="String";
		float v4=0.1f;
		double v5=0.422;
		//implicit
		float v6=v1;
		double v7=v4;
		int v8=v2;
		//explicit
		char v9=(char)v8;
		float v10=(float)v7;
		int v11=(int)v5;
		
	}

}
