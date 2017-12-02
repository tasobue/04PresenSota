//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.network.*;
import	java.net.Socket;
import	java.net.ServerSocket;
import	java.io.BufferedReader;
import	java.io.InputStreamReader;
import	java.io.OutputStreamWriter;
import	java.io.BufferedWriter;
import	java.io.PrintWriter;
import	java.io.IOException;
import	java.awt.Color;

public class mymain
{

	public int ECHO_PORT;
	public String ECHO_IP;
	public CRobotPose pose;
	public String speechRecogResult;
	public RecogResult recogresult;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,576,32,False,6,@</BlockInfo>
	{
																														//@<OutputChild>
		ECHO_PORT=10007;																								//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
		ECHO_IP="172.16.168.62";																						//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*String speechRecogResult*/;																					//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*RecogResult recogresult*/;																					//@<BlockInfo>jp.vstone.block.variable,416,32,416,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,64,256,784,560,False,18,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"準備OK",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,128,256,128,256,False,17,@</BlockInfo>
																														//@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,192,256,176,560,False,16,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,272,208,768,208,False,14,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 "開始" ,  "終了" ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)"開始"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					int intPptNo=0;																							//@<BlockInfo>jp.vstone.block.variable,352,208,352,208,False,11,break@</BlockInfo>
																															//@<EndOfBlock/>
					intPptNo=(int)selectPPT((int)intPptNo);																	//@<BlockInfo>jp.vstone.block.callfunc.base,464,208,464,208,False,10,@</BlockInfo>	@<EndOfBlock/>
					GlobalVariable.sotawish.Say((String)"プレゼン、はーじまーるよー",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,544,208,544,208,False,9,@</BlockInfo>
																															//@<EndOfBlock/>
					presentation((int)intPptNo);																			//@<BlockInfo>jp.vstone.block.callfunc.base,608,208,608,208,False,8,@</BlockInfo>	@<EndOfBlock/>
					intPptNo=(int)0;																						//@<BlockInfo>jp.vstone.block.calculater,672,208,672,208,False,7,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"終了"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					break;																									//@<BlockInfo>jp.vstone.block.break,352,304,352,304,False,12,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"もう一度言え。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,352,400,352,400,False,13,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)"またね～",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);			//@<BlockInfo>jp.vstone.block.talk.say,336,560,336,560,False,15,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void presentation(int pptNo)																					//@<BlockInfo>jp.vstone.block.func,64,1296,608,1776,False,33,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		String sendMsg="Test";																							//@<BlockInfo>jp.vstone.block.variable,128,1296,128,1296,False,32,break@</BlockInfo>
																														//@<EndOfBlock/>
		Socket socket = null;																							//@<BlockInfo>jp.vstone.block.freeproc,192,1296,192,1296,False,31,@</BlockInfo>
		BufferedReader rcv = null;
		PrintWriter snd = null;
																														//@<EndOfBlock/>
		int presenEndFlg=0;																								//@<BlockInfo>jp.vstone.block.variable,256,1296,256,1296,False,30,break@</BlockInfo>
																														//@<EndOfBlock/>
		int intSpchSeq=0;																								//@<BlockInfo>jp.vstone.block.variable,320,1296,320,1296,False,29,break@</BlockInfo>
																														//@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,512,1296,64,1776,False,28,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			intSpchSeq=(int)intSpchSeq + 1;																				//@<BlockInfo>jp.vstone.block.calculater,64,1424,64,1424,False,27,@</BlockInfo>
																														//@<EndOfBlock/>
			String resultMsg="失敗";																						//@<BlockInfo>jp.vstone.block.variable,128,1424,128,1424,False,26,break@</BlockInfo>
																														//@<EndOfBlock/>
			try {																										//@<BlockInfo>jp.vstone.block.freeproc,192,1424,192,1424,False,25,@</BlockInfo>
				System.out.println("000");
				if(socket == null){
					System.out.println("001");
					socket = new Socket(ECHO_IP, ECHO_PORT);
					rcv = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					snd = new PrintWriter(socket.getOutputStream());
				}else{

				}

				if(socket  != null){

					System.out.println("003");

					snd.println(intSpchSeq);
					System.out.println("intSpchSeq:" + intSpchSeq);
					snd.flush();
					System.out.println("004");
					String rcvMsg = rcv.readLine();

					if (rcvMsg != null) {
						resultMsg = new String(rcvMsg.getBytes("UTF-8"), "UTF-8");
						if("end".equals(resultMsg)){
							presenEndFlg = 1;
							socket.close();
						}
			                                          else if("wait".equals(resultMsg)){
			                                                        presenEndFlg = 9;
			                                          }
			                                          else{
			                                                        presenEndFlg  = 0;
			                                          }
					} else {

					}
				}
				System.out.println("005");


			} catch (IOException e) {
				e.printStackTrace();

			} finally {



			}
																														//@<EndOfBlock/>
			if(presenEndFlg==0)																							//@<BlockInfo>jp.vstone.block.if,272,1456,544,1456,False,24,コメント@</BlockInfo>
			{
																														//@<OutputChild>
				pose = new CRobotPose();																				//@<BlockInfo>jp.vstone.block.pose,336,1456,336,1456,False,20,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{0,-900,0,900,0,0,0,0}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,800);
				CRobotUtil.wait(800);																					//@<EndOfBlock/>
				GlobalVariable.sotawish.Say((String)resultMsg,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,400,1456,400,1456,False,19,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
			else if(presenEndFlg==9)
			{
																														//@<OutputChild>
				intSpchSeq=(int)0;																						//@<BlockInfo>jp.vstone.block.calculater,336,1552,336,1552,False,22,@</BlockInfo>
																														//@<EndOfBlock/>
				pose = new CRobotPose();																				//@<BlockInfo>jp.vstone.block.pose,400,1552,400,1552,False,21,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{0,-900,0,900,0,0,0,0}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,800);
				CRobotUtil.wait(800);																					//@<EndOfBlock/>
																														//@</OutputChild>
			}
			else
			{
																														//@<OutputChild>
				break;																									//@<BlockInfo>jp.vstone.block.break,336,1648,336,1648,False,23,break@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	/*
	intSpchSeq=0;																										//@<BlockInfo>jp.vstone.block.variable,608,2224,608,2224,False,37,break@</BlockInfo>
																														//@<EndOfBlock/>

	*/

	//@<Separate/>
	public int selectPPT(int _intPptNo)																					//@<BlockInfo>jp.vstone.block.func,80,752,976,752,False,46,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		GlobalVariable.sotawish.Say((String)"どれをプレゼンする？",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,176,752,176,752,False,45,@</BlockInfo>
																														//@<EndOfBlock/>
		while(GlobalVariable.TRUE)																						//@<BlockInfo>jp.vstone.block.while.endless,272,896,640,896,False,44,Endless@</BlockInfo>
		{

																														//@<OutputChild>
			recogresult = GlobalVariable.recog.getRecognitionwithAbort((int)60000);										//@<BlockInfo>jp.vstone.block.talk.speechrecog.score2,336,752,576,752,False,47,音声認識を行い、認識候補との完全一致で比較する。認識スコアが一番高い結果に分岐する。実際に認識された文字列はspeechRecogResultに代入される@</BlockInfo>
			speechRecogResult = recogresult.CheckBest(new String[]{
			 "一番" ,  "二番" ,  "三番" ,  "" , 
			},false);
			if(speechRecogResult == null) speechRecogResult = "";

			if(speechRecogResult.contains((String)"一番"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					_intPptNo=(int)1;																						//@<BlockInfo>jp.vstone.block.calculater,416,752,416,752,False,35,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,480,752,480,752,False,34,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"二番"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					_intPptNo=(int)1;																						//@<BlockInfo>jp.vstone.block.calculater,416,848,416,848,False,38,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,480,848,480,848,False,36,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else if(speechRecogResult.contains((String)"三番"))
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					_intPptNo=(int)1;																						//@<BlockInfo>jp.vstone.block.calculater,416,944,416,944,False,40,@</BlockInfo>
																															//@<EndOfBlock/>
					break;																									//@<BlockInfo>jp.vstone.block.break,480,944,480,944,False,39,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

			}
			else
			{
				speechRecogResult = recogresult.getBasicResult();
				if(speechRecogResult == null) speechRecogResult = "";

																														//@<OutputChild>
					GlobalVariable.sotawish.Say((String)"もう一度言え。",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,416,1040,416,1040,False,41,@</BlockInfo>
																															//@<EndOfBlock/>
																																//@</OutputChild>

			}
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
		GlobalVariable.sotawish.Say((String)Integer.toString(_intPptNo) + "が選択されました",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,704,896,704,896,False,43,@</BlockInfo>
																														//@<EndOfBlock/>
		return _intPptNo;																								//@<BlockInfo>jp.vstone.block.return,784,896,784,896,False,42,return@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
