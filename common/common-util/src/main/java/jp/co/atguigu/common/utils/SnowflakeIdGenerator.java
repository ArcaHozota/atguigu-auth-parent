package jp.co.atguigu.common.utils;

/**
 * 雪花のアルゴリズムID生成クラス
 *
 * @author JCccc
 * @since 2019-06-12
 */
public class SnowflakeIdGenerator {

	// ==============================Fields===========================================
	/** 初期値時間(2015-01-01) */
	private static final long TIME_EPOCH = 1420041600000L;

	/** ワークIDの桁数 */
	private static final long WORKER_ID_BITS = 5L;

	/** データセンターIDの桁数 */
	private static final long DATACENTER_ID_BITS = 5L;

	/** 最大のワークID */
	private final long maxWorkerId = -1L ^ (-1L << WORKER_ID_BITS);

	/** 最大のデータセンターID */
	private final long maxDatacenterId = -1L ^ (-1L << DATACENTER_ID_BITS);

	/** シークエンスの桁数 */
	private static final long SEQUENCE_BITS = 12L;

	/** ワークIDのシフト桁数 */
	private final long workerIdShift = SEQUENCE_BITS;

	/** データセンターIDのシフト桁数 */
	private final long datacenterIdShift = SEQUENCE_BITS + WORKER_ID_BITS;

	/** タイムスタンプのシフト桁数 */
	private final long timestampLeftShift = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

	/** シークエンスマスク */
	private final long sequenceMask = -1L ^ (-1L << SEQUENCE_BITS);

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
	 * コンストラクタ
	 *
	 * @param workerId     ワークID(最大値は31)
	 * @param datacenterId データセンターID(最大値は31)
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
	 * 次の雪花アルゴリズムID
	 *
	 * @return long 雪花アルゴリズムID
	 */
	protected synchronized long nextId() {
		// 今の時間
		long timestamp = System.currentTimeMillis();
		// 今の時間は前のタイムスタンプより早くと、エラーになります
		if (timestamp < this.lastTimestamp) {
			throw new RuntimeException(
					String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
							this.lastTimestamp - timestamp));
		}
		// 同じ時間であれば、シークエンスを使う
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & this.sequenceMask;
			if (this.sequence == 0) {
				// 次のミリ秒までタイムスタンプえお取得する
				timestamp = this.tillNextMillis(this.lastTimestamp);
			}
		} else {
			// タイムスタンプが変えれば、シークエンスをリセットする
			this.sequence = 0L;
		}
		// 前のタイムスタンプとして保存
		this.lastTimestamp = timestamp;
		// 新たな雪花アルゴリズムIDを生成
		return ((timestamp - TIME_EPOCH) << this.timestampLeftShift) | (this.datacenterId << this.datacenterIdShift)
				| (this.workerId << this.workerIdShift) | this.sequence;
	}

	/**
	 * 次のミリ秒までタイムスタンプえお取得する
	 *
	 * @param lastTimestamp 前のタイムスタンプ
	 * @return 今の時間
	 */
	private long tillNextMillis(final long lastTimestamp) {
		long timestamp = System.currentTimeMillis();
		while (timestamp <= lastTimestamp) {
			timestamp = System.currentTimeMillis();
		}
		return timestamp;
	}
}
