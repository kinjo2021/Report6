package jp.ac.uryukyu.ie.e215734;
import java.util.Random;
import java.util.Scanner;
 
public class Janken {
 
	public static void main(String[] args) {
 
		// ユーザの手をキーボードから入力してもらう
		int user = getUser();
		//　設定決定
		int runk = getRunk();
		//　設定を参照、相手の出す手を決定
        int runber = getRanber(runk,user);

		// コンピュータの手を乱数で作成する
		//int pc = getPc();
 
		// 勝敗の判定を行う
		String result = judgeJanken(user,runber);
 
		// 結果を表示する
		showResult(user,runber,result);
	}
 
	public static int getUser() {
		// キーボード入力の準備
		Scanner stdin = new Scanner(System.in);
 
		// 無限ループ
		while(true) {
			// メッセージの表示
			System.out.println("あなたのじゃんけんの手を入力して下さい");
			System.out.print("(グー：0，チョキ：1、パー：2)　--> ");
 
			// 入力されたデータが整数かどうかのチェック
			if(stdin.hasNextInt()) {
				// 入力されたデータを整数として読み込む
				int number = stdin.nextInt();
				// 整数でも有効なのは「0，1，2」のみ
				if(number<=-1 || number >=3) {
					// 範囲外は無効なデータなのでやり直し
					System.out.println("【エラー】入力できるのは「0～2」です");
					continue;
				}else {
					// 0,1,2の場合、メソッドの結果として返す
					return number;
				}
			}else {
				// 整数以外の場合、無効なデータなのでやり直し
				System.out.println("【エラー】入力できるのは整数だけです");
				// 不要なトークンをバッファから取り除く
				stdin.next();
			}
		}
	}
	public static int getRunk(){
        Random number = new Random();
        return number.nextInt(5);
    }

    public static int getRanber(int runk,int user) {
        int pc;
        int count=0;
		int i;
		for(i = 0; i < 1000; i++){
        //設定０　勝てない
        if((runk == 0 || user == 1) || (runk == 0 || user == 2) || (runk == 0 || user == 3)){
            pc = user;
            Random rand = new Random();
            int rumber = rand.nextInt(4);
			if(rumber == pc - 1){
                return rumber;
            }else{
                continue;
            }
        //設定１　勝率低下    
        }else if((runk == 1 || user == 1) || (runk == 1 || user == 2) || (runk == 1 || user == 3)){
            pc = user;
            Random rand = new Random();
            int rumber = rand.nextInt(4);
            if(rumber == pc + 1){
                count++;
                continue;
            }else if(rumber == pc + 1 && count==1){
                return rumber;
            }else{
                return rumber;
            }
        //設定２　通常確率    
        }else if((runk == 2 || user == 1) || (runk == 2 || user == 2) || (runk == 2 || user == 3)){
            Random rand = new Random();
		    int rumber = rand.nextInt(4);
            if(rumber == 0){
                continue;
            }else{
                return rumber;
            }
        //設定３　勝率上昇    
        }else if((runk == 3 || user == 1) || (runk == 3 || user == 2) || (runk == 3 || user == 3)){
            pc = user;
            Random rand = new Random();
            int rumber = rand.nextInt(4);
            if(rumber == pc + 1){
                count++;
                continue;
            }else if(rumber == pc + 1 && count==1){
                return rumber;
            }else{
                return rumber;
            }
        //設定４　勝確    
        }else if((runk == 4 || user == 1) || (runk == 4 || user == 2) || (runk == 4 || user == 3)){
            pc = user;
            Random rand = new Random();
            int rumber = rand.nextInt(4);
            if(rumber == pc + 1){
                return rumber;
            }else{
                continue;
            }
        }
		}
    }

 
	/*public static int getPc() {
		// 乱数の準備
		Random rand = new Random();
		// 0,1,2のどれかを求め、メソッドの結果として返す
		return rand.nextInt(3);
	}*/
 
	public static String judgeJanken(int user,int pc) {
		String result=""; // 判定結果を保存する
 
		if((user==0 && pc==1) || (user==1 && pc==2) || (user==2 && pc==0)) {
			result="勝ち";
		}else if( (user==0 && pc==2) || (user==1 && pc==0) || (user==2 && pc==1)) {
			result="まけ";
		}else {
			result="あいこ";
		}
 
		// 勝敗結果を返す
		return result;
	}
 
	public static void showResult(int user,int pc,String result) {
		// じゃんけんの手を配列で定義
		String[] janken= {"グー","チョキ","パー"};
		// 結果の表示
		System.out.println("あなたの手:"+janken[user]+",コンピュータの手:"+janken[pc]);
		System.out.println("結果："+result);
 
	}
}
