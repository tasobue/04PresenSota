import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MessageClass {
	private String _filePath;
	private ArrayList<String> _genkoLists;
	
    private int _speechSeq;
    private String _speechTxt;
    private ArrayList<String> _speechTxts;
	
    public MessageClass(){
        _speechSeq = -1;
        _speechTxt = "";
    	_speechTxts = new ArrayList<String>();
    	_filePath = System.getProperty("user.dir");
    	_genkoLists = setGenkoLists();
    }
	
	/**
	*readGenkoFile
	*�����@String fileNm�@�ǂݍ��ތ��eCSV
	*���e��CSV�t�@�C����ǂݍ��݂P�s�P�ʂ�ArrayList�N���X�Ɋi�[���܂��B
	*CSV�͂��̃N���X�Ɠ����f�B���N�g���ɂ���t�@�C����ǂݍ��݂܂��B
	*/
	public void readGenkoFile(String pptNo){
		try{
			
			String fileNm = getFileNm(Integer.parseInt(pptNo));
			File file = new File(_filePath + "\\" + fileNm);
			
			if (checkBeforeReadfile(file)){
        		BufferedReader br = new BufferedReader(new FileReader(file));

        		String str;
        		while((str = br.readLine()) != null){
        			_speechTxts.add(str);
        		}

        		br.close();
			
			}else{
        		
      		}

		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public boolean isServerWait(String fileNm){
		boolean isServerWaitFlg = true;
		try{
			File file = new File(_filePath + "\\" + fileNm);
			
			
			if (checkBeforeReadfile(file)){
        		//wait�t�@�C��������ꍇ
				isServerWaitFlg =  true;
			
			}else{
        		//wait�t�@�C�����Ȃ��ꍇ
				isServerWaitFlg =  false;
      		}

		}  catch(Exception e){
			e.printStackTrace();
		}finally {
			return isServerWaitFlg;
		}
		
	}
	
	/**
	*	getMsgFrmCsv	
	*	CSV�̎w�肵���s����e�L�X�g��ǂݍ��݂܂��B
	*	@param seq�FCSV�̉��s�ڂ�ǂݍ��ނ����������l
	*	@return String ���e�e�L�X�g
	*
	*/
    public String getMsgFrmCsv(int seq){
    	System.out.println("getMsgFrmCsv:" + seq);
    	
    	if(_speechTxts.size() < seq ){
    		_speechTxt = "end";
    	}else{
    		_speechTxt = _speechTxts.get(seq -1);
    	}
        System.out.println("_speechTxt:" + _speechTxt);
       return _speechTxt;
    }
	
	/**
	*	checkBeforeReadfile
	*	�����@File file�F�ǂݍ��ݑΏۂ̃t�@�C��
	*	�t�@�C�����ǂݍ��݉\���Ԃ��܂��B
	*	�߂�l�@true:�ǂݍ��݉\�@False�F�ǂݍ��ݕs��
	*/
	
	private static boolean checkBeforeReadfile(File file){
	    if (file.exists()){
	      if (file.isFile() && file.canRead()){
	        return true;
	      }
	    }
	    return false;
	}
	
	
	/**
	*getFileNm
	*���e�e�L�X�g�̃t�@�C�������擾����
    *
	*/
	private String getFileNm(int _pptNo){
		return _genkoLists.get(_pptNo +1);
	}
	
	/**
	* setGenkoLists
	* ���e���ꗗ���Z�b�g����
	*/
	private ArrayList<String> setGenkoLists(){
		_genkoLists = new ArrayList<String>();
		_genkoLists.add("genko.csv");
		return _genkoLists;
	}
}