package jp.co.iccom.yamashita_naomi.calculate_sales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileReadbranch {
	public static void main(String[] args){
		//引数の確認
	    if (args.length == 0){
	    	System.out.println("引数がありません。");
	    }else if(args.length >= 2){
	    	System.out.println("引数が2個以上あります。");
	    	return;
	    }
	    
	    //コマンドライン引数を取得する
	    String path = args[0];
	    
		//支店定義ファイルの読み込みを行う
        try {
            File fib = new File(path,"branch.lst");
            if (checkBeforeReadfileb(fib)){
            	FileReader inb = new FileReader(fib);
            	BufferedReader brb = new BufferedReader(inb);
            	//支店定義ファイルを一行ずつデータを読み込み、
            	//全ての支店コードとそれに対応する支店名を保持する。
            	String lineb;
            	HashMap<String,String> map = new HashMap<String,String>();

            	while ((lineb = brb.readLine()) != null) {
            	    String strb = lineb;
            	    String[] lstb = strb.split(",");
            	    if(lstb.length() && ){
                	//※条件を要素数が2個、コードが3であることのフォーマットの不正の確認を行うこと！！！
                	//カンマ改行がはいっている可能性 splitでやった結果の要素数

            	    	map.put(lstb[0],lstb[1]);	
            	    }else{
            	    	System.out.println("支店定義ファイルフォーマットが不正です。");
            	    }
            	    System.out.println(map);
            	}
            	inb.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }


		//商品定義ファイルの読み込みを行う
        try {
            File fic = new File(path,"commodity.lst");
            if (checkBeforeReadfilec(fic)){
            		FileReader inc = new FileReader(fic);
            		BufferedReader brc = new BufferedReader(inc);
            		//商品定義ファイルを一行ずつデータを読み込み、
            		//全ての商品コードとそれに対応する商品名を保持する。
            		String linec;
                   	HashMap<String,String> map = new HashMap<String,String>();
                  //※条件を要素数が2個、コードが8であることのフォーマットの不正の確認を行うこと！！！
            		while ((linec = brc.readLine()) != null) {
                   	    String strc = linec;
                   	    String[] lstc = strc.split(",");
                   	    map.put(lstc[0],lstc[1]);
                   	    System.out.println(map);
            			}
            		inc.close();
                 }
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

	private static boolean checkBeforeReadfileb(File fib){
		//ファイルの存在を確認
		if (fib.exists()){
			//対象のファイルクラスのオブジェクトがファイルであるかを確認
			//読み込み可能か確認
		    if (fib.isFile() && fib.canRead()){
		      return true;
		    }
	  }else{
		  System.out.println("支店定義ファイルが見つかりません。");
	  }
	  return false;
	}


	private static boolean checkBeforeReadfilec(File fic){
		if (fic.exists()){
			if (fic.isFile() && fic.canRead()){
				return true;
			}
		}else{
			System.out.println("商品定義ファイルが見つかりません。");
		}
		return false;
	}
	
}


