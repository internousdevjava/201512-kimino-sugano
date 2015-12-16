import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1=null;
		String str2=null;
		int a=1;
		int b=1;
		boolean flag=true;
		while(flag){
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n『九九の計算』");
			System.out.println("それぞれの最大値を指定して下さい");
			System.out.println("範囲は1～100までです");
			try{
				System.out.println("\nxの最大値");
				str1=br.readLine();
				System.out.println("\nyの最大値");
				str2=br.readLine();
				//数字かどうかの判断
				if(!str1.matches("^[0-9]*$")||!str2.matches("^[0-9]*$")){
					System.out.println("xまたはyの値を半角の整数で入力して下さい");
					continue;

				}else{
				}
				int x=Integer.parseInt(str1);
				int y=Integer.parseInt(str2);
					System.out.println("\n");
					if (x>100||x<1||y>100||y<1){
						System.out.println("xまたはyの数値の範囲が正しくありません");
						continue;
					}else{
						//x*yのループ文
						for(a=1;a<=x;a++){
							for(b=1;b<=y;b++){
								int s =a*b;
								if ((x<10)&&(y<10)){
									if (s < 10) {
										System.out.print("  ");
									}else{
										System.out.print(" ");
									}
								}else{
									if (s<10) {
										System.out.print("    ");
									}else if(s<100){
										System.out.print("   ");
									}else if(s<1000) {
										System.out.print("  ");
									}else{
										System.out.print(" ");
									}
								}
								System.out.print(s);
							}
							System.out.println("");
						}
					}
			}
			catch(IOException e){
				e.printStackTrace();
				continue;
			}
		}
	}
}