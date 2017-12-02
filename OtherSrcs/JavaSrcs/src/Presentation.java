public class Presentation {
	
	public static final String PPT_NAME = "presen.pptx";
	public static final String WAIT_FILE_NAME = "wait.txt";
	public static final String WAIT_MESSAGE = "wait";
	public static final String END_MESSAGE = "end";	
	
	public MessageClass msgCls;
	public PowerpointOperation ppt;
	
	public Presentation(){
	     msgCls = new MessageClass();
	     ppt = new PowerpointOperation();
	}
	
	
	public void setPresentaion(String _pptNo){
		//原稿を読み込む
    	msgCls.readGenkoFile(_pptNo);
	}
	
	public String getSpeechTxt(String _rcvSeq){
		String strMsgs;			//メッセージクラスからの戻り値
    	String[] strMsgsArr;	//メッセージクラスからの戻り値をカンマ区切りで分割
    	String spchText;		//Sotaが話す内容
    	String strMotionCd;		//Sotaの動作を指定する番号
    	String strPgNo;			//PPTのページ番号
		
		
		//メッセージの取得
        strMsgs = msgCls.getMsgFrmCsv(Integer.parseInt(_rcvSeq));
    	
    	if(END_MESSAGE.equals(strMsgs)){
    		//Sotaに終了処理の合図を送る
    		spchText = strMsgs;
    		return spchText;
    	}else{
			
        	strMsgsArr = strMsgs.split(",", 0);
        	strPgNo = strMsgsArr[1]; //ページ番号
        	spchText = strMsgsArr[2];//Sotaが話す内容
        	strMotionCd = strMsgsArr[3];//Sotaの動作を指定する番号
        	
        	//pptを操作
        	if("1".equals(_rcvSeq)){
        		System.out.println("ppt.openPptFile");
        		ppt.openPptFile(PPT_NAME);
        	}else{
        		System.out.println("ppt.slidePage");
        		ppt.slidePage(strPgNo);
        	}
        	
        	//クライアントにメッセージ送信
            return spchText;
    	
    	}
	}
}