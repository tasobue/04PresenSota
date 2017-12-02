public class SotaController {
	private Presentation prsn;
	
	public SotaController(){
		prsn = new Presentation();
	}
	
	/**
	selectPpt
	プレゼンするパワーポイントの指定
	**/
	public void selectPpt(String _pptNo){
		prsn.setPresentaion(_pptNo);
	}
	
	/**
	doPresentation
	プレゼンの実行
	戻り値：Sotaに発話させる文字列
	**/
	public String doPresentation(String _seqNo){
		String spchTxt;
		spchTxt = prsn.getSpeechTxt(_seqNo);
		
		return spchTxt;
	}
}