package cn.ablocker.ccs.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportData {
	private String device;
	private float time;
	private float longitude;
	private float latitude;
	private int clientCount;
	private float speedCount;
	private String soft;
	private String status;
}
