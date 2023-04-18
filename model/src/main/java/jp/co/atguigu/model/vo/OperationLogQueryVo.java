package jp.co.atguigu.model.vo;

import lombok.Data;

@Data
public class OperationLogQueryVo {
	private String title;
	private String operName;
	private String createTimeBegin;
	private String createTimeEnd;
}
