public class SotaController {
	private Presentation prsn;
	
	public SotaController(){
		prsn = new Presentation();
	}
	
	/**
	selectPpt
	�v���[������p���[�|�C���g�̎w��
	**/
	public void selectPpt(String _pptNo){
		prsn.setPresentaion(_pptNo);
	}
	
	/**
	doPresentation
	�v���[���̎��s
	�߂�l�FSota�ɔ��b�����镶����
	**/
	public String doPresentation(String _seqNo){
		String spchTxt;
		spchTxt = prsn.getSpeechTxt(_seqNo);
		
		return spchTxt;
	}
}