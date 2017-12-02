public class Presentation {
	
	public static final String PPT_NAME = "presen.pptx";
	public static final String WAIT_FILE_NAME = "wait.txt";
	public static final String WAIT_MESSAGE = "wait";
	public static final String END_MESSAGE = "end";	
	
	}
	
	public String getSpeechTxt(String _rcvSeq){
		String strMsgs;			//���b�Z�[�W�N���X����̖߂�l
    	String[] strMsgsArr;	//���b�Z�[�W�N���X����̖߂�l��J���}��؂�ŕ���
    	String spchText;		//Sota���b����e
    	String strMotionCd;		//Sota�̓����w�肷��ԍ�
    	String strPgNo;			//PPT�̃y�[�W�ԍ�
		
		
		//���b�Z�[�W�̎擾
        strMsgs = msgCls.getMsgFrmCsv(Integer.parseInt(_rcvSeq));
    	
    	if(END_MESSAGE.equals(strMsgs)){
    		//Sota�ɏI�������̍��}�𑗂�
    		spchText = strMsgs;
    		return spchText;
    	}else{
			
        	strMsgsArr = strMsgs.split(",", 0);
        	strPgNo = strMsgsArr[1]; //�y�[�W�ԍ�
        	spchText = strMsgsArr[2];//Sota���b����e
        	strMotionCd = strMsgsArr[3];//Sota�̓����w�肷��ԍ�
        	
        	//ppt�𑀍�
        		System.out.println("ppt.openPptFile");
        		ppt.openPptFile(PPT_NAME);
        	}else{
        		System.out.println("ppt.slidePage");
        		ppt.slidePage(strPgNo);
        	}
        	
        	//�N���C�A���g�Ƀ��b�Z�[�W���M
            return spchText;
    	
    	}
	}
}
