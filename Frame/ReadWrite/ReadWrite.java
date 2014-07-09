package Frame.ReadWrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

public class ReadWrite {
	public static final String ROOT = "/Volumes/";
	public static final String MISC = "/MISC/";
	public static final String MUSIC = "//MISC//";
	public static final String T = "\\";
	public static final String[] readfilename = { 
		"//Users//arienkakkowara//dropbox//がめ.m3u8",
		"//Users//arienkakkowara//dropbox//おきにげーむ.m3u8",
		"//Users//arienkakkowara//dropbox//げんせん.m3u8",
		"//Users//arienkakkowara//dropbox//とーほー.m3u8",
		"//Users//arienkakkowara//dropbox//ぬ.m3u8" };
	public static final String[] writefilename = {
		"//Users//arienkakkowara//dropbox//がめ.m3u",
		"//Users//arienkakkowara//dropbox//おきにげーむ.m3u",
		"//Users//arienkakkowara//dropbox//げんせん.m3u",
		"//Users//arienkakkowara//dropbox//とーほー.m3u",
		"//Users//arienkakkowara//dropbox//ぬ.m3u" };
	/**
	 * 音楽ファイルの転送
	 * @param rfilename
	 * @param wfilename
	 * @return result
	 */
	public static int RWMusic(String rfilename, String copypath) {
		File inputFile;
		String middle, tmppath;

		// ファイルオブジェクトの生成
		inputFile = new File(rfilename);
		
		if( !inputFile.isFile()) {
			// 開けなかった場合は終了
			System.out.println("can't open!");
			return -1;
		}
		
		try {
			// 入力ストリームの生成
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(inputFile), "utf-8"));

			// テキストファイルからの読み込み
			String msg;

			// ファイルの終わりまで読み込む
			while ((msg = br.readLine()) != null) {
				// 拡張子がmp3の時
				if (msg.endsWith(".mp3")) {
					// コピー先のファイルパス設定
					middle = msg.substring(msg.indexOf("Music/Music")+11);
					tmppath = copypath + middle;
					// ディレクトリ作成
					new File(tmppath.replace(new File(tmppath).getName(), "")).mkdirs();
					// ファイルコピー
					ReadWrite.copyTransfer(msg, tmppath);
				}
			}

			// 後始末
			br.close();

			System.out.println("Program end.");

			return 0;

		} catch (Exception e) {
			// エラーがあった場合はスタックトレースを出力
			e.printStackTrace();
			return -2;
		}
	}
	
	/**
	 * プレイリストの転送
	 * @param rfilename
	 * @param wfilename
	 * @return
	 */
	public static int RWList(String rfilename, String path) {
		File inputFile, outputFile;
		String tmppath;	
		
		// ファイルオブジェクトの生成
		inputFile = new File(rfilename);
		tmppath = path+inputFile.getName().replace(".m3u8", ".m3u");
		outputFile = new File(tmppath);
		
		System.out.println(outputFile.getPath());
		
		// ディレクトリ作成
		new File(tmppath.replace(outputFile.getName(), "")).mkdirs();
		
		if( !inputFile.isFile() || !outputFile.isFile() ) {
			// どちらか開けなかった場合は終了
			System.out.println("can't open!");
			return -1;
		}
		
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
				String tmp = "";
				list = msg.split("/");
				
				// 読み込んだ文字列msgの中に"/"が3個未満ー>ファイル名
				if (list.length < 3)
					tmp = msg;
				// そうでない->ファイルパス
				else  
					tmp = msg.substring(msg.indexOf("Music/Music/")+12);
				
				// ファイルの書き込み
				pw.write(tmp+"\n");

				// 読み込んだ文字列と書き込んだ文字列の表示
				System.out.println("read  : " + tmp);
				System.out.println("write : " + tmp);
			}

			System.out.println(outputFile.getPath());
			
			// 後始末
			br.close();
			pw.close();

			System.out.println("Program end.");

			return 0;

		} catch (Exception e) {
			// エラーがあった場合はスタックトレースを出力
			e.printStackTrace();
			return -2;
		}
	}
	
	/**
	 * プレイリストにある音楽ファイルを転送するよ
	 * @param rfilename
	 * @param wfilename
	 * @param copypath
	 * @return
	 */
	private static int RWMusicAndList(String rfilename, String copypath) {
		File inputFile, outputFile;
		String tmppath, middle;
		
		// ファイルオブジェクトの生成
		inputFile = new File(rfilename);
		tmppath = (copypath+inputFile.getName());
		outputFile = new File(tmppath);
		
		// どうして作ったのか忘れてしまったif文
		if(outputFile.isDirectory());
		
		System.out.println(rfilename);
		System.out.println(copypath+inputFile.getName());
		
		for(File f : new File(copypath).listFiles())
			System.out.println(f.toString());

		if( !inputFile.isFile() ) {
			// どちらか開けなかった場合は終了
			System.out.println("can't open input file!");
		}
		if( !outputFile.isFile() ) {
			// どちらか開けなかった場合は終了
			System.out.println("can't open output file!");
		}
		
		
		if( !inputFile.isFile() || !outputFile.isFile() ) {
			// どちらか開けなかった場合は終了
			System.out.println("can't open!");
			return -1;
		}
		
		
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

			// ファイルの終わりまで読み込む
			while ((msg = br.readLine()) != null) {
				
				// 拡張子がmp3の時
				if (msg.endsWith(".mp3")) {
					// コピー先のファイルパス設定
					middle = msg.substring(msg.indexOf("Music/Music")+11);
					tmppath = copypath + middle;
					// ディレクトリ作成
					new File(tmppath.replace(new File(tmppath).getName(), "")).mkdirs();
					//System.out.println(ReadWrite.makeFolder(msg.replace("/"+ new File(tmppath).getName(), ""), copypath));
					// ファイルコピー
					ReadWrite.copyTransfer(msg, tmppath);
				}
				
				String tmp = "";
				
				list = msg.split("/");
				
				// 読み込んだ文字列msgの中に"/"が3個未満ー>ファイル名
				if (list.length < 3)
					tmp = msg;
				// そうでない->ファイルパス
				else  {
					tmp = msg.substring(msg.indexOf("Music/Music/")+12);
				}
				
				// ファイルの書き込み
				pw.write(tmp+"/n");
				
				// 読み込んだ文字列と書き込んだ文字列の表示
				System.out.println("read  : " + msg);
				System.out.println("write : " + tmp);
			}

			// 後始末
			br.close();
			pw.close();

			System.out.println("Program end.");

			return 0;

		} catch (Exception e) {
			// エラーがあった場合はスタックトレースを出力
			e.printStackTrace();
			return -2;
		}
		
	}
	
	/**
	 * コピー元のパス[srcPath]から、コピー先のパス[destPath]へ
	 * ファイルのコピーを行います。
	 * コピー処理にはFileChannel#transferToメソッドを利用します。
	 * 尚、コピー処理終了後、入力・出力のチャネルをクローズします。
	 * @param srcPath    コピー元のパス
	 * @param destPath    コピー先のパス
	 */
	public static void copyTransfer(String srcPath, String destPath) {
		FileChannel srcChannel, destChannel;
		
	    try {
	    	srcChannel = new FileInputStream(srcPath).getChannel();
	    	destChannel = new FileOutputStream(destPath).getChannel();
	        srcChannel.transferTo(0, srcChannel.size(), destChannel);
	        srcChannel.close();
	        destChannel.close();
	    } catch (FileNotFoundException e) {
	    	System.out.println("file not found.");
	    	e.printStackTrace();
	    } catch (IOException e) {
			System.out.println("copy error.");
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param path
	 * @param phonename
	 * @return
	 */
	public static boolean ListTransfer(File path,String phonename) {
		// コピー先のファイルパス設定
		String copypath = ROOT + phonename + MISC;
		
		if(ReadWrite.RWList(path.getPath(), copypath)==0)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @param path
	 * @param phonename
	 * @return
	 */
	public static boolean MusicTransfer(File path, String phonename) {
		// コピー先のファイルパス設定
		String copypath = ROOT + phonename + MISC;
		
		if(ReadWrite.RWMusic(path.getPath(), copypath) == 0)
			return true;
		else 
			return false;
	}

	/**
	 * 
	 * @param path
	 * @param phonename
	 * @return
	 */
	public static boolean MusicAndListTransfer(File path, String phonename) {
		// コピー先のファイルパス設定
		String copypath = ROOT + phonename + MISC;
		
		if(ReadWrite.RWMusicAndList(path.getPath(), copypath) == 0)
			return true;
		else
			return false;
	}
	
}
