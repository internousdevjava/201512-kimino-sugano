import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai3{

	/**
	 * @param <SSample1_1>
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static <SSample1_1> void main(String[] args) throws IOException {
		String str;
		String file_name;
		String write;
		String dir_name;
		String folder_name;
		boolean flag = true;
		while (flag) {
			System.out.println("実行メニューを選択してください");
			System.out.println("[1]:読み込み,[2]:書き込み,[3]:新規作成,[9]終了");
			//入力メニューの数値判定
			try{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				str=br.readLine();
				int n=0;
				if(str.matches("^[0-9]*$")){
					n=Integer.parseInt(str);
				}else{
					System.out.println("半角数字で入力して下さい");
				    }
				//読込
			if(n==1){
				System.out.println("読み込むファイルを名を指定して下さい,[0]:メニューに戻る");
				System.out.println("例：c:\\xxxx\\xxx.txt");
				try{
					BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
					file_name=br2.readLine();
					if(("0".equals(file_name))){
						continue;
						}
					File file = new File(file_name);
					BufferedReader buf=new BufferedReader(new FileReader(file));
					while((str=buf.readLine())!=null){
							System.out.println(str);
							}
					  		buf.close();
					}catch(FileNotFoundException e){
						System.out.println(e);
			}catch (IOException e) {
				e.printStackTrace();
				}
			}
			//書き込み
			else if(n==2){
				System.out.println("書き込むファイル名を指定して下さい,[0]:メニューに戻る");
				System.out.println("例：c\\xxxx\\xxx.txt");
				try{
					BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
					file_name=br2.readLine();
					if(("0".equals(file_name))){
						continue;
						}//ファイル・ディレクトリの判別
					File file = new File(file_name);
					if(!file.exists()){
						System.out.println("ファイルが見つかりません");
						continue;
					}if (file.isDirectory()) {
						System.out.println("※※※ファイルでなく、ディレクトリが選択されています※※※");
						continue;
					}
					System.out.println("[1]:上書き,[2]:追記,[0]:メニューに戻る");
					BufferedReader br3=new BufferedReader(new InputStreamReader(System.in));
					str=br3.readLine();
					int num=0;
					if(("0".equals(str))){
						continue;
						};
					if(str.matches("^[0-9]*$")){
						num=Integer.parseInt(str);
					}else{
						System.out.println("半角数字で入力して下さい");
					}
					//上書き処理
					if(num==1){
						try{
							System.out.println("書き込む内容を入力して下さい,[0]:メニューに戻る");
							PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,false)));
							BufferedReader br4=new BufferedReader(new InputStreamReader(System.in));
							write=br4.readLine();
							if("0".equals(write)){
								continue;
							}
							pw.println(write);
							pw.close();
							System.out.println("上書きが完了しました");
						}catch (IOException e) {
							System.out.println(e);//例外エラー
						}
						//追記処理
					}else if(num==2){
						try{
							System.out.println("書き込む内容を入力して下さい,[0]:メニューに戻る");
							PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
							BufferedReader br4=new BufferedReader(new InputStreamReader(System.in));
							write=br4.readLine();
							if("0".equals(write)){
								continue;
							}
							pw.println(write);
							pw.close();
							System.out.println("追記が完了しました");
						}catch (IOException e) {
							System.out.println(e);//例外エラー
						}
					}else{
						System.out.println("メニューに表示されている数値から選択して下さい");
						continue;
					}
				} catch (IOException e) {
				System.out.println(e);
				}
			}
			//新規作成
			else if(n==3){
				try{
					System.out.println("選択して下さい");
					System.out.println("[1]:ファイルの作成,[2]:フォルダの作成[0]:メニューに戻る");
					BufferedReader br5=new BufferedReader(new InputStreamReader(System.in));
					str= br5.readLine();
					int numb=0;
					if(("0".equals(str))){
						continue;
						};
					if(str.matches("^[0-9]*$")){
						numb=Integer.parseInt(str);
					}else{
						System.out.println("半角数字で入力して下さい");
					}
					if(numb==1){
						System.out.println("新しいファイル名を指定して下さい");
						System.out.println("例：c:\\xxxx\\xxx.txt");
						BufferedReader br6=new BufferedReader(new InputStreamReader(System.in));
						file_name = br6.readLine();
						File newfile = new File(file_name);//作成したい
							try{
								if(newfile.exists()){
									System.out.println("ファイルが既に存在します");
								}else{
									System.out.println("ファイルがありませんので作成します。 パス:"+newfile.getAbsolutePath());
									try{
										if(newfile.createNewFile()) {
											System.out.println("ファイルが作成されました");
										}else{
											System.out.println("作成失敗");
										}
									}catch(IOException e){
										System.out.println(e);
									}
								}
							}catch (Exception e) {
								e.printStackTrace();
							}
					}
					else if(numb==2){
						System.out.println("新しいフォルダ名を指定して下さい");
						System.out.println("例:c:\\xxx\\xx");
						BufferedReader br7=new BufferedReader(new InputStreamReader(System.in));
						folder_name=br7.readLine();
						File newfile=new File(folder_name);
						File dir = new File(newfile.getAbsolutePath());
						if(dir.exists()){
							System.out.println("フォルダが既に存在します");
						}else{
							System.out.println("フォルダがありませんので作成します。 パス:"+newfile.getAbsolutePath());
						if(newfile.mkdir()){
							System.out.println("ディレクトリの作成に成功しました");
						}else{
							System.out.println("ディレクトリの作成に失敗しました");
						}
						}
					}else{
						System.out.println("メニューに表示されている数値から選択して下さい");
						continue;
					}
				}catch(IOException e){
					System.out.println(e);
					}
			}
			//終了
			else if(n==9){
				System.out.println("作業を終了します");
				System.out.println("ありがとうございました");
				break;
		}else{
			System.out.println("メニューに表示されている数値から選択して下さい");
			continue;
			}
			}finally{
		}
	}
	}
}
