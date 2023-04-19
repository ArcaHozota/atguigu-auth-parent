package jp.co.atguigu.common.utils;

/**
 * 雪花のアルゴリズムID生成クラス
 *
 * @author: JCccc
 * @date 2019-06-12
 */
public class SnowflakeIdGenerator {
	// ==============================Fields===========================================
	/** 初期値時間(2015-01-01) */
	private final long timeEpoch = 1420041600000L;

	/** ワークIDの桁数 */
	private final long workerIdBits = 5L;

	/** データセンターIDの桁数 */
	private final long datacenterIdBits = 5L;

	/** 最大のワークID */
	private final long maxWorkerId = -1L ^ (-1L << this.workerIdBits);

	/** 最大のデータセンターID */
	private final long maxDatacenterId = -1L ^ (-1L << this.datacenterIdBits);

	/** シークエンスの桁数 */
	private final long sequenceBits = 12L;

	/** ワークIDのシフト桁数 */
	private final long workerIdShift = this.sequenceBits;

	/** データセンターIDのシフト桁数 */
	private final long datacenterIdShift = this.sequenceBits + this.workerIdBits;

	/** タイムスタンプのシフト桁数 */
	private final long timestampLeftShift = this.sequenceBits + this.workerIdBits + this.datacenterIdBits;

	/** シークエンスマスク */
	private final long sequenceMask = -1L ^ (-1L << this.sequenceBits);

	/** ワークID */
	private final long workerId;

	/** データセンターID */
	private final long datacenterId;

	/** シークエンス */
	private long sequence = 0L;

	/** 前のタイムスタンプ */
	private long lastTimestamp = -1L;

	// ==============================Constructors=====================================
	/**
	 * 构造函数
	 *
	 * @param workerId     工作ID (0~31)
	 * @param datacenterId 数据中心ID (0~31)
	 */
	protected SnowflakeIdGenerator(final long workerId, final long datacenterId) {
		if (workerId > this.maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
		}
		if (datacenterId > this.maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(
					String.format("datacenter Id can't be greater than %d or less than 0", this.maxDatacenterId));
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	// ==============================Methods==========================================
	/**
	 * 获得下一个ID (该方法是线程安全的)
	 *
	 * @return SnowflakeId
	 */
	protected synchronized long nextId() {
		long timestamp = System.currentTimeMillis();
		// 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
		if (timestamp < this.lastTimestamp) {
			throw new RuntimeException(
					String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
							this.lastTimestamp - timestamp));
		}
		// 如果是同一时间生成的，则进行毫秒内序列
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & this.sequenceMask;
			// 毫秒内序列溢出
			if (this.sequence == 0) {
				// 阻塞到下一个毫秒,获得新的时间戳
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		}
		// 时间戳改变，毫秒内序列重置
		else {
			this.sequence = 0L;
		}
		// 上次生成ID的时间截
		this.lastTimestamp = timestamp;
		// 移位并通过或运算拼到一起组成64位的ID
		return ((timestamp - this.timeEpoch) << this.timestampLeftShift) | (this.datacenterId << this.datacenterIdShift)
				| (this.workerId << this.workerIdShift) | this.sequence;
	}

	/**
	 * 阻塞到下一个毫秒，直到获得新的时间戳
	 *
	 * @param lastTimestamp 上次生成ID的时间截
	 * @return 当前时间戳
	 */
	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = System.currentTimeMillis();
		while (timestamp <= lastTimestamp) {
			timestamp = System.currentTimeMillis();
		}
		return timestamp;
	}
}
