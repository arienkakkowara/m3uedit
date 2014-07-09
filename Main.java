import java.io.*;

public class Main {
	public static final String T = "\\";
	public static void main(String[] args) {
		
		// プレイリストのファイルパスと書き込み先のファイルパス
		String[]
		readfilename = {
			// ココに入力元のファイルパス。下に例をだしておくよ
			"//Users//arienkakkowara//dropbox//ぬ.m3u8"
		},
		writefilename = {
			// ココに出力先のパス。下に例をだしておくよ
			"//Users//arienkakkowara//dropbox//ぬ.m3u"
		};
		
		// ファイルの数だけループ
		for(int i = 0; i < readfilename.length && i < writefilename.length; i++){
			// ファイルオブジェクトの生成
			File inputFile = new File(readfilename[i]);
			File outputFile = new File(writefilename[i]);

			try {
				// 入力ストリームの生成
				BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFile), "utf-8"));

				// 出力ストリームの生成
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(
					new FileOutputStream(outputFile), "utf-8"));

				// テキストファイルからの読み込み
				String msg;
				String[] list;

				while ((msg = br.readLine()) != null) {
					System.out.println("read  : "+msg);
					list = msg.split("/");
					if (list.length < 3) {
						pw.println(msg);
						System.out.println("write : "+msg);
					} else {
						pw.println(list[list.length - 3]+T+list[list.length - 2]+T+list[list.length - 1]);
						System.out.println("write : "+list[list.length - 3]+T+list[list.length - 2]+T+list[list.length - 1]);
					}
				}

				// 後始末
				br.close();
				pw.close();

				System.out.println("Program end.");

			// エラーがあった場合はスタックトレースを出力
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
