/**
 * List some good design idea
 */

public class GoodDesign {

	/**
   * 用于多线程调试
   * 另外在执行状态非常复杂的时候也可以设计把运行步骤只打印不执行帮助调试。
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
