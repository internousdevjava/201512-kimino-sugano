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
public class KisoKadai2{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("数当てゲーム");
		//答えをコンピュータに決定させる
		int answer=new java.util.Random().nextInt(99)+1;
		//解答回数のループ文
	for(int i=10;i>0;i--){
		System.out.println("1～100の整数を、半角数字で入力して下さい");
		System.out.println("解答はあと"+i+"回");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String yourAns=null;
		//数値かどうかの判断
		try{
			yourAns=br.readLine();
			if(!yourAns.matches("^[0-9]*$")){
				System.out.println("半角の整数でお願いします。");i++;
				continue;
			}else{
			}
			//解答の正誤判断
			int x=Integer.parseInt(yourAns);
			if(x>100||x<1){
				System.out.println("1～100までの整数でお願いします。");i++;
			}else if(x<answer){
				System.out.println("もっと大きい数です！");
			}else if(x>answer){
				System.out.println("もっと小さい数です！");
			}else{
		    	System.out.println("正解です！");
		    	break;
			}
		}catch(IOException e){
			e.printStackTrace();
		}continue;
	}System.out.println("ゲーム終了！答えは"+answer+"でした！");
	}
}
