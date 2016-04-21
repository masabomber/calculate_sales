package jp.co.iccom.yamashita_naomi.calculate_sales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileReadbranch {
	public static void main(String[] args) {
        try {
            File fi = new File("C:\\calculate_sales\\branch.lst");
            FileReader in = new FileReader(fi);
            BufferedReader br = new BufferedReader(in);
            
            String line;
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            in.close();
            
        } catch (IOException e) {
            System.out.println("支店定義ファイルが見つかりません。");
        }
    }
}

//エンコード処理
/*
 1. コマンドライン引数で指定されたディレクトリから支店定義ファイルを開く。
	→支店定義ファイルが存在しない場合「支店定義ファイルが存在しません」を表示し、処理を終了する。

 2. 支店定義ファイルを一行ずつデータを読み込み、全ての支店コードとそれに対応する支店名を保持する。
 	ファイルフォーマットが不正な場合は、「支店定義ファイルのフォーマットが不正です」を表示し、処理を終了する。*/