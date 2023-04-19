package jp.co.atguigu.common.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 共通ページングクラス
 *
 * @author Administrator
 * @param <T>
 */
public final class Pagination<T> {

	/**
	 * 毎ページのレコード
	 */
	private List<T> records;

	/**
	 * 当ページ
	 */
	private int pageNum;

	/**
	 * ページサイズ
	 */
	private int pageSize;

	/**
	 * すべてのページ数
	 */
	private int totalPages;

	/**
	 * すべてのレコード数
	 */
	private int totalRecords;

	/**
	 * 前のページはあるか
	 */
	private boolean hasPreviousPage = false;

	/**
	 * 次のページはあるか
	 */
	private boolean hasNextPage = false;

	/**
	 * 前のページ
	 */
	private int previousPage;

	/**
	 * 次のページ
	 */
	private int nextPage;

	/**
	 * ナビゲーションのページ数
	 */
	private int navigatePages;

	/**
	 * ナビゲーションの第一ページ
	 */
	private int naviFirstPage;

	/**
	 * ナビゲーションの最後ページ
	 */
	private int naviLastPage;

	/**
	 * ナビゲーションページの数の集合
	 */
	private int[] navigatePageNums;

	/**
	 * Paginationを取得する
	 *
	 * @param records      レコード
	 * @param totalRecords すべてのレコード数
	 * @param pageNum      当ページ
	 */
	public static <T> Pagination<T> of(final List<T> records, final int totalRecords, final int pageNum) {
		return new Pagination<>(records, totalRecords, pageNum, 17, 5);
	}

	/**
	 * Paginationを取得する
	 *
	 * @param records      レコード
	 * @param totalRecords すべてのレコード数
	 * @param pageNum      当ページ
	 * @param pageSize     ページサイズ
	 */
	public static <T> Pagination<T> of(final List<T> records, final int totalRecords, final int pageNum,
			final int pageSize) {
		return new Pagination<>(records, totalRecords, pageNum, pageSize, 5);
	}

	/**
	 * Paginationを取得する
	 *
	 * @param records       レコード
	 * @param totalRecords  すべてのレコード数
	 * @param pageNum       当ページ
	 * @param pageSize      ページサイズ
	 * @param navigatePages ナビゲーションのページ数
	 */
	public static <T> Pagination<T> of(final List<T> records, final int totalRecords, final int pageNum,
			final int pageSize, final int navigatePages) {
		return new Pagination<>(records, totalRecords, pageNum, pageSize, navigatePages);
	}

	/**
	 * コンストラクタ
	 *
	 * @param records       レコード
	 * @param totalRecords  すべてのレコード数
	 * @param pageNum       当ページ
	 * @param pageSize      ページサイズ
	 * @param navigatePages ナビゲーションのページ数
	 */
	private Pagination(final List<T> records, final int totalRecords, final int pageNum, final int pageSize,
			final int navigatePages) {
		if (records != null && !records.isEmpty()) {
			this.pageNum = pageNum;
			this.records = records;
			this.pageSize = records.size();
			this.totalRecords = totalRecords;
			final int ape = this.totalRecords / pageSize;
			this.totalPages = this.totalRecords % pageSize == 0 ? ape : ape + 1;
		} else if (records.isEmpty()) {
			this.pageNum = 1;
			this.records = null;
			this.pageSize = 0;
			this.totalRecords = 0;
			this.totalPages = 1;
		} else {
			throw new RuntimeException("データのコレクションは間違いました。");
		}
		this.calcByNavigatePages(navigatePages);
	}

	/**
	 * ナビゲーションのページ数によって色んな計算処理を行う
	 *
	 * @param navigatePages ナビゲーションのページ数
	 */
	private void calcByNavigatePages(final int navigatePages) {
		// ナビゲーションのページ数を設定する
		this.setNavigatePages(navigatePages);
		// ナビゲーションページの数の集合を取得する
		this.calcNavigatePageNums();
		// 前のページ、次のページ、最初及び最後のページを取得する
		this.calcPage();
		// ページングエッジを判断する
		this.discernPageBoundary();
	}

	/**
	 * ナビゲーションページの数の集合を取得する
	 */
	private void calcNavigatePageNums() {
		if (this.totalPages <= this.navigatePages) {
			this.navigatePageNums = new int[this.totalPages];
			for (int i = 0; i < this.totalPages; i++) {
				this.navigatePageNums[i] = i + 1;
			}
		} else {
			this.navigatePageNums = new int[this.navigatePages];
			int startNum = this.pageNum - this.navigatePages / 2;
			int endNum = this.pageNum + this.navigatePages / 2;
			if (startNum < 1) {
				startNum = 1;
				// 最初のナビゲーションページ
				for (int i = 0; i < this.navigatePages; i++) {
					this.navigatePageNums[i] = startNum++;
				}
			} else if (endNum > this.totalPages) {
				endNum = this.totalPages;
				// 最後のナビゲーションページ
				for (int i = this.navigatePages - 1; i >= 0; i--) {
					this.navigatePageNums[i] = endNum--;
				}
			} else {
				// 他のナビゲーションページ
				for (int i = 0; i < this.navigatePages; i++) {
					this.navigatePageNums[i] = startNum++;
				}
			}
		}
	}

	/**
	 * 前のページ、次のページ、最初及び最後のページを取得する
	 */
	private void calcPage() {
		if (this.navigatePageNums != null && this.navigatePageNums.length > 0) {
			this.naviFirstPage = this.navigatePageNums[0];
			this.naviLastPage = this.navigatePageNums[this.navigatePageNums.length - 1];
			if (this.pageNum > 1) {
				this.previousPage = this.pageNum - 1;
			}
			if (this.pageNum < this.totalPages) {
				this.nextPage = this.pageNum + 1;
			}
		}
	}

	/**
	 * ページングエッジを判断する
	 */
	private void discernPageBoundary() {
		this.hasPreviousPage = this.pageNum > 1;
		this.hasNextPage = this.pageNum < this.totalPages;
	}

	/**
	 * 内容はあるかどうかを判断する
	 */
	public boolean hasContent() {
		return this.records.size() > 0;
	}

	/**
	 * getter for records
	 *
	 * @return records
	 */
	public List<T> getRecords() {
		return this.records;
	}

	/**
	 * setter of records
	 *
	 * @param records セットする records
	 */
	public void setRecords(final List<T> records) {
		this.records = records;
	}

	/**
	 * getter for pageNum
	 *
	 * @return pageNum
	 */
	public int getPageNum() {
		return this.pageNum;
	}

	/**
	 * setter of pageNum
	 *
	 * @param pageNum セットする pageNum
	 */
	public void setPageNum(final int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * getter for pageSize
	 *
	 * @return pageSize
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * setter of pageSize
	 *
	 * @param pageSize セットする pageSize
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * getter for totalPages
	 *
	 * @return totalPages
	 */
	public int getTotalPages() {
		return this.totalPages;
	}

	/**
	 * setter of totalPages
	 *
	 * @param totalPages セットする totalPages
	 */
	public void setTotalPages(final int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * getter for totalRecords
	 *
	 * @return totalRecords
	 */
	public int getTotalRecords() {
		return this.totalRecords;
	}

	/**
	 * setter of totalRecords
	 *
	 * @param totalRecords セットする totalRecords
	 */
	public void setTotalRecords(final int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * getter for hasPreviousPage
	 *
	 * @return hasPreviousPage
	 */
	public boolean isHasPreviousPage() {
		return this.hasPreviousPage;
	}

	/**
	 * setter of hasPreviousPage
	 *
	 * @param hasPreviousPage セットする hasPreviousPage
	 */
	public void setHasPreviousPage(final boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	/**
	 * getter for hasNextPage
	 *
	 * @return hasNextPage
	 */
	public boolean isHasNextPage() {
		return this.hasNextPage;
	}

	/**
	 * setter of hasNextPage
	 *
	 * @param hasNextPage セットする hasNextPage
	 */
	public void setHasNextPage(final boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	/**
	 * getter for previousPage
	 *
	 * @return previousPage
	 */
	public int getPreviousPage() {
		return this.previousPage;
	}

	/**
	 * setter of previousPage
	 *
	 * @param previousPage セットする previousPage
	 */
	public void setPreviousPage(final int previousPage) {
		this.previousPage = previousPage;
	}

	/**
	 * getter for nextPage
	 *
	 * @return nextPage
	 */
	public int getNextPage() {
		return this.nextPage;
	}

	/**
	 * setter of nextPage
	 *
	 * @param nextPage セットする nextPage
	 */
	public void setNextPage(final int nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * getter for navigatePages
	 *
	 * @return navigatePages
	 */
	public int getNavigatePages() {
		return this.navigatePages;
	}

	/**
	 * setter of navigatePages
	 *
	 * @param navigatePages セットする navigatePages
	 */
	public void setNavigatePages(final int navigatePages) {
		this.navigatePages = navigatePages;
	}

	/**
	 * getter for naviFirstPage
	 *
	 * @return naviFirstPage
	 */
	public int getNaviFirstPage() {
		return this.naviFirstPage;
	}

	/**
	 * setter of naviFirstPage
	 *
	 * @param naviFirstPage セットする naviFirstPage
	 */
	public void setNaviFirstPage(final int naviFirstPage) {
		this.naviFirstPage = naviFirstPage;
	}

	/**
	 * getter for naviLastPage
	 *
	 * @return naviLastPage
	 */
	public int getNaviLastPage() {
		return this.naviLastPage;
	}

	/**
	 * setter of naviLastPage
	 *
	 * @param naviLastPage セットする naviLastPage
	 */
	public void setNaviLastPage(final int naviLastPage) {
		this.naviLastPage = naviLastPage;
	}

	/**
	 * getter for navigatePageNums
	 *
	 * @return navigatePageNums
	 */
	public int[] getNavigatePageNums() {
		return this.navigatePageNums;
	}

	/**
	 * setter of navigatePageNums
	 *
	 * @param navigatePageNums セットする navigatePageNums
	 */
	public void setNavigatePageNums(final int[] navigatePageNums) {
		this.navigatePageNums = navigatePageNums;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Pagination [records=" + this.records + ", pageNum=" + this.pageNum + ", pageSize=" + this.pageSize
				+ ", totalPages=" + this.totalPages + ", totalRecords=" + this.totalRecords + ", hasPrePage="
				+ this.hasPreviousPage + ", hasNextPage=" + this.hasNextPage + ", previousPage=" + this.previousPage
				+ ", nextPage=" + this.nextPage + ", navigatePages=" + this.navigatePages + ", naviFirstPage="
				+ this.naviFirstPage + ", naviLastPage=" + this.naviLastPage + ", navigatePageNums="
				+ Arrays.toString(this.navigatePageNums) + "]";
	}
}
