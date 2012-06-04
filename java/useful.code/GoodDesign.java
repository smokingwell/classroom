/**
 * List some good design idea
 */

public class GoodDesign {

	/**
   * ���ڶ��̵߳���
   * ������ִ��״̬�ǳ����ӵ�ʱ��Ҳ������ư����в���ֻ��ӡ��ִ�а������ԡ�
   * This code clips come from NSN BTAF project.
   * 
	 * Start a new thread for execution task, and Dslam connection is setup
	 * before the execution.
	 */
	private void startExecutionThread() {
		Logger.devlog("");
		/*
		 * false: release version, multi-thread. true: debug version, single
		 * thread.
		 */
		boolean singleThreadDebug = false;

		if (!singleThreadDebug) {
			this.exeThread = new Thread(this);
			exeThread.start();
		} else {
			run();
		}
	}

}
