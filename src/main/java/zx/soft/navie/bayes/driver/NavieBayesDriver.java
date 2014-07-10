package zx.soft.navie.bayes.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.navie.bayes.db.DbRecordToHDFS;
import zx.soft.navie.bayes.mapreduce.NavieBayesDistribute;
import zx.soft.navie.bayes.simple.NavieBayesSimple;
import zx.soft.navie.bayes.traindatapretreatment.TrainDataProcessing;

/**
 * 驱动类
 * @author zhumm
 *
 */
public class NavieBayesDriver {

	private static Logger logger = LoggerFactory.getLogger(NavieBayesDriver.class);

	/**
	 * 主函数
	 */
	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("Usage: Driver <class-name>");
			System.exit(-1);
		}
		String[] leftArgs = new String[args.length - 1];
		System.arraycopy(args, 1, leftArgs, 0, leftArgs.length);

		switch (args[0]) {
		case "navieBayesSimple":
			logger.info("简单的Navie Bayes实现： ");
			NavieBayesSimple.main(leftArgs);
			break;
		case "NavieBayesDistribute":
			logger.info("分布式Navie Bayes实现： ");
			NavieBayesDistribute.main(leftArgs);
			break;
		case "trainDataPretreatment":
			logger.info("分布式 Navie Bayes 训练数据处理、准备");
			TrainDataProcessing.main(leftArgs);
		case "dbRecordPretreatmentToHDFS":
			logger.info("预处理来自于MySQL中的待分类数据");
			DbRecordToHDFS.main(leftArgs);
		default:
			return;
		}

	}

}
