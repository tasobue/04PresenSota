//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	jp.vstone.network.*;
import	java.awt.Color;
import	java.util.*;

public class mymain
{

	public CRobotPose pose;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,0,160,0,False,2,@</BlockInfo>
	{
																														//@<OutputChild>
		/*CRobotPose pose*/;																							//@<BlockInfo>jp.vstone.block.variable,96,0,96,0,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,0,320,1296,320,False,30,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		pose = new CRobotPose();																						//@<BlockInfo>jp.vstone.block.pose,80,320,80,320,False,29,コメント@</BlockInfo>
		pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{0,-900,0,900,0,0,0,0}
						);
		pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
						new Short[]{100,100,100,100,100,100,100,100}
						);
		pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
						new Short[]{0,-255,0,180,80,0,180,80,0}
						);
		GlobalVariable.motion.play(pose,400);
		CRobotUtil.wait(400);																							//@<EndOfBlock/>
		{																												//@<BlockInfo>jp.vstone.block.tcpip.server.init,144,320,1232,320,False,28,@</BlockInfo>
			TCPIPServer tcpipServer = new TCPIPServer((short)5001,(int)60000);
			
																														//@<OutputChild>
			CRobotUtil.Log(getClass().getSimpleName(), (String)"◆初期化完了");												//@<BlockInfo>jp.vstone.block.printlog,208,320,208,320,False,27,@</BlockInfo>	@<EndOfBlock/>
			while(GlobalVariable.TRUE)																					//@<BlockInfo>jp.vstone.block.while.endless,400,320,1040,320,False,26,Endless@</BlockInfo>
			{

																														//@<OutputChild>
				CRobotUtil.Log(getClass().getSimpleName(), (String)"◆まち");												//@<BlockInfo>jp.vstone.block.printlog,464,320,464,320,False,23,@</BlockInfo>	@<EndOfBlock/>
				try{																									//@<BlockInfo>jp.vstone.block.tcpip.server,544,176,1008,176,False,22,@</BlockInfo>
					GlobalVariable.recvString = tcpipServer.waitRequest();

					if(GlobalVariable.recvString==null) GlobalVariable.recvString="";
					if(GlobalVariable.recvString.contentEquals((String)"End"))
					{
																														//@<OutputChild>
						CRobotUtil.Log(getClass().getSimpleName(), (String)GlobalVariable.recvString);						//@<BlockInfo>jp.vstone.block.printlog,608,176,608,176,False,9,@</BlockInfo>	@<EndOfBlock/>
						{																									//@<BlockInfo>jp.vstone.block.lock,608,96,1024,80,False,8,関節のロック@</BlockInfo>
							ArrayList<Byte> svList = new ArrayList<Byte>();
							ArrayList<Byte> LEDList = new ArrayList<Byte>();
						
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_L_ELBOW,CSotaMotion.SV_L_SHOULDER}));
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_R_ELBOW,CSotaMotion.SV_R_SHOULDER}));
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_HEAD_P,CSotaMotion.SV_HEAD_Y,CSotaMotion.SV_HEAD_R}));
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_BODY_Y}));
							if(true) LEDList.addAll(Arrays.asList(new Byte[]{0,1,2}));
							if(true) LEDList.addAll(Arrays.asList(new Byte[]{8,9,10,11,12,13}));
						
							if(svList.size()>0) GlobalVariable.motion.LockServoHandle((Byte[]) svList.toArray(new Byte[0]));
							if(LEDList.size()>0) GlobalVariable.motion.LockLEDHandle((Byte[]) LEDList.toArray(new Byte[0]));
						
							{
							
							
																															//@<OutputChild>
								pose = new CRobotPose();																		//@<BlockInfo>jp.vstone.block.pose,720,0,720,0,False,6,コメント@</BlockInfo>
								pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
												new Short[]{-378,-773,-1,722,-1,-3,-224,2}
												);
								pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
												new Short[]{100,100,100,100,100,100,100,100}
												);
								pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
												new Short[]{0,-255,0,180,80,0,180,80,0}
												);
								GlobalVariable.motion.play(pose,1000);															//@<EndOfBlock/>
								{																								//@<BlockInfo>jp.vstone.block.thread,736,96,864,96,False,5,スレッド@</BlockInfo>
									Thread th = new Thread(new Runnable() {
										@Override
										public void run() {
											try{
												
												
																																//@<OutputChild>
												GlobalVariable.sotawish.Say((String)"ご清聴有難うございました",MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,800,96,800,96,False,3,@</BlockInfo>
																																			//@<EndOfBlock/>
																																				//@</OutputChild>
								
												
											} catch(Exception e) {
												CRobotUtil.Err("jp.vstone.block.thread","例外が発生しました。");
												e.printStackTrace();
											}
										}
									});
									th.start();
								}
																																//@<EndOfBlock/>
								pose = new CRobotPose();																		//@<BlockInfo>jp.vstone.block.pose,912,0,912,0,False,4,コメント@</BlockInfo>
								pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
												new Short[]{-625,-755,-699,688,776,-5,20,6}
												);
								pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
												new Short[]{100,100,100,100,100,100,100,100}
												);
								pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
												new Short[]{0,-255,0,180,80,0,180,80,0}
												);
								GlobalVariable.motion.play(pose,1000);
								CRobotUtil.wait(1000);																			//@<EndOfBlock/>
								pose = new CRobotPose();																		//@<BlockInfo>jp.vstone.block.pose,976,0,976,0,False,52,コメント@</BlockInfo>
								pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
												new Short[]{-378,-773,-1,722,-1,-3,-224,2}
												);
								pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
												new Short[]{100,100,100,100,100,100,100,100}
												);
								pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
												new Short[]{0,-255,0,180,80,0,180,80,0}
												);
								GlobalVariable.motion.play(pose,1000);
								CRobotUtil.wait(1000);																			//@<EndOfBlock/>
																																	//@</OutputChild>
						}
							
						
							if(svList.size()>0) GlobalVariable.motion.UnLockServoHandle((Byte[]) svList.toArray(new Byte[0]));
							if(LEDList.size()>0) GlobalVariable.motion.UnLockLEDHandle((Byte[]) LEDList.toArray(new Byte[0]));
						}																									//@<EndOfBlock/>
						break;																								//@<BlockInfo>jp.vstone.block.break,1136,96,1136,96,False,7,break@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
					else
					{
																														//@<OutputChild>
						String[] receiveStrAry=new String[3];																//@<BlockInfo>jp.vstone.block.variable,608,272,608,272,False,21,break@</BlockInfo>
																															//@<EndOfBlock/>
						CRobotUtil.Log(getClass().getSimpleName(), (String)GlobalVariable.recvString);						//@<BlockInfo>jp.vstone.block.printlog,672,272,672,272,False,20,@</BlockInfo>	@<EndOfBlock/>
						receiveStrAry=(String[])GlobalVariable.recvString.split(",",0);										//@<BlockInfo>jp.vstone.block.calculater,736,272,736,272,False,19,@</BlockInfo>
																															//@<EndOfBlock/>
						String varReceiveSpeechText=(String)receiveStrAry[2];												//@<BlockInfo>jp.vstone.block.variable,800,272,800,272,False,18,break@</BlockInfo>
																															//@<EndOfBlock/>
						String varReceiveMotionCd;																			//@<BlockInfo>jp.vstone.block.variable,416,464,416,464,False,17,break@</BlockInfo>
																															//@<EndOfBlock/>
						varReceiveMotionCd=(String)receiveStrAry[1];														//@<BlockInfo>jp.vstone.block.calculater,480,464,480,464,False,16,@</BlockInfo>
																															//@<EndOfBlock/>
						CRobotUtil.Log(getClass().getSimpleName(), (String)varReceiveSpeechText);							//@<BlockInfo>jp.vstone.block.printlog,544,464,544,464,False,15,@</BlockInfo>	@<EndOfBlock/>
						{																									//@<BlockInfo>jp.vstone.block.lock,416,560,736,560,False,14,関節のロック@</BlockInfo>
							ArrayList<Byte> svList = new ArrayList<Byte>();
							ArrayList<Byte> LEDList = new ArrayList<Byte>();
						
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_L_ELBOW,CSotaMotion.SV_L_SHOULDER}));
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_R_ELBOW,CSotaMotion.SV_R_SHOULDER}));
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_HEAD_P,CSotaMotion.SV_HEAD_Y,CSotaMotion.SV_HEAD_R}));
							if(true) svList.addAll(Arrays.asList(new Byte[]{CSotaMotion.SV_BODY_Y}));
							if(true) LEDList.addAll(Arrays.asList(new Byte[]{0,1,2}));
							if(true) LEDList.addAll(Arrays.asList(new Byte[]{8,9,10,11,12,13}));
						
							if(svList.size()>0) GlobalVariable.motion.LockServoHandle((Byte[]) svList.toArray(new Byte[0]));
							if(LEDList.size()>0) GlobalVariable.motion.LockLEDHandle((Byte[]) LEDList.toArray(new Byte[0]));
						
							{
							
							
																															//@<OutputChild>
								selectMotion((String)varReceiveMotionCd);														//@<BlockInfo>jp.vstone.block.callfunc.base,480,560,480,560,False,12,@</BlockInfo>	@<EndOfBlock/>
								{																								//@<BlockInfo>jp.vstone.block.thread,544,560,672,560,False,11,スレッド@</BlockInfo>
									Thread th = new Thread(new Runnable() {
										@Override
										public void run() {
											try{
												
												
																																//@<OutputChild>
												GlobalVariable.sotawish.Say((String)varReceiveSpeechText,MotionAsSotaWish.MOTION_TYPE_TALK,(int)11,(int)13,(int)11);	//@<BlockInfo>jp.vstone.block.talk.say,608,560,608,560,False,10,@</BlockInfo>
																																			//@<EndOfBlock/>
																																				//@</OutputChild>
								
												
											} catch(Exception e) {
												CRobotUtil.Err("jp.vstone.block.thread","例外が発生しました。");
												e.printStackTrace();
											}
										}
									});
									th.start();
								}
																																//@<EndOfBlock/>
																																	//@</OutputChild>
						}
							
						
							if(svList.size()>0) GlobalVariable.motion.UnLockServoHandle((Byte[]) svList.toArray(new Byte[0]));
							if(LEDList.size()>0) GlobalVariable.motion.UnLockLEDHandle((Byte[]) LEDList.toArray(new Byte[0]));
						}																									//@<EndOfBlock/>
						motionSpeeching((String)varReceiveMotionCd);														//@<BlockInfo>jp.vstone.block.callfunc.base,816,560,816,560,False,13,@</BlockInfo>	@<EndOfBlock/>
																																//@</OutputChild>

					}
					
				} catch(Exception e) { }
																														//@<EndOfBlock/>
																														//@</OutputChild>
			}
																														//@<EndOfBlock/>
			pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,1104,320,1104,320,False,25,コメント@</BlockInfo>
			pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{0,-900,0,900,0,0,0,0}
							);
			pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
							new Short[]{100,100,100,100,100,100,100,100}
							);
			pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
							new Short[]{0,-255,0,180,80,0,180,80,0}
							);
			GlobalVariable.motion.play(pose,400);
			CRobotUtil.wait(400);																						//@<EndOfBlock/>
			CRobotUtil.Log(getClass().getSimpleName(), (String)"◆ループ抜けました");											//@<BlockInfo>jp.vstone.block.printlog,1168,320,1168,320,False,24,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>

			
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void selectMotion(String motionCd)																			//@<BlockInfo>jp.vstone.block.func,64,784,496,784,False,39,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		CRobotUtil.Log(getClass().getSimpleName(), (String)motionCd);													//@<BlockInfo>jp.vstone.block.printlog,128,784,128,784,False,38,@</BlockInfo>	@<EndOfBlock/>
		switch((String)motionCd)																						//@<BlockInfo>jp.vstone.block.switch,192,688,432,688,False,37,@</BlockInfo>
		{
			case (String)"001":
			{
																														//@<OutputChild>
				CRobotUtil.Log(getClass().getSimpleName(), (String)motionCd);												//@<BlockInfo>jp.vstone.block.printlog,256,688,256,688,False,32,@</BlockInfo>	@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,320,688,320,688,False,31,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{0,-900,0,900,0,0,0,0}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,1200);																		//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"002":
			{
																														//@<OutputChild>
				CRobotUtil.Log(getClass().getSimpleName(), (String)motionCd);												//@<BlockInfo>jp.vstone.block.printlog,256,784,256,784,False,34,@</BlockInfo>	@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,320,784,320,784,False,33,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{62,655,-33,688,777,463,-196,-9}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,255,0,0,255,0}
								);
				GlobalVariable.motion.play(pose,800);																		//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			default:
			{
																														//@<OutputChild>
				CRobotUtil.Log(getClass().getSimpleName(), (String)"003通過");												//@<BlockInfo>jp.vstone.block.printlog,256,880,256,880,False,36,@</BlockInfo>	@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,320,880,320,880,False,35,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-1044,-593,-881,280,-14,-337,-188,-3}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void motionSpeeching(String motionCd)																		//@<BlockInfo>jp.vstone.block.func,608,768,1248,768,False,51,@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		switch((String)motionCd)																						//@<BlockInfo>jp.vstone.block.switch,672,672,1184,672,False,50,@</BlockInfo>
		{
			case (String)"001":
			{
																														//@<OutputChild>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,736,672,736,672,False,42,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-378,-773,-1,722,-1,-3,-224,2}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,1200);
				CRobotUtil.wait(1200);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,800,672,800,672,False,41,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-625,-755,-699,688,776,-5,20,6}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,864,672,864,672,False,40,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-378,-773,-1,722,-1,-3,-224,2}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{0,-255,0,180,80,0,180,80,0}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}
			case (String)"002":
			{
																														//@<OutputChild>
																														//@</OutputChild>
				break;
			}
			default:
			{
																														//@<OutputChild>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,736,864,736,864,False,49,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-1044,-594,-881,279,-13,-337,28,4}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,800,864,800,864,False,48,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-45,-64,-3,395,881,204,-270,-5}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,864,864,864,864,False,47,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-45,-58,-367,395,880,205,-53,-6}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,928,864,928,864,False,46,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-46,-183,-84,395,882,200,-270,-5}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,992,864,992,864,False,45,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{1,-467,51,396,26,126,-270,-5}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,1056,864,1056,864,False,44,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-5,13,-52,823,34,95,-253,-28}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
				pose = new CRobotPose();																					//@<BlockInfo>jp.vstone.block.pose,1120,864,1120,864,False,43,コメント@</BlockInfo>
				pose.SetPose(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{-4,61,-890,823,35,92,-250,-242}
								);
				pose.SetTorque(	new Byte[]{1,2,3,4,5,6,7,8},
								new Short[]{100,100,100,100,100,100,100,100}
								);
				pose.SetLed(	new Byte[]{0,1,2,8,9,10,11,12,13},
								new Short[]{255,0,0,0,0,255,0,0,255}
								);
				GlobalVariable.motion.play(pose,1000);
				CRobotUtil.wait(1000);																						//@<EndOfBlock/>
																																//@</OutputChild>
				break;
			}

		}																												//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
