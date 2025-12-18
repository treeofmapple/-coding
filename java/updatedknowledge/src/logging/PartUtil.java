package logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class PartUtil extends Formatter {

	@Override
	public String format(LogRecord record) {
		return record.getLevel() + ":" + record.getMessage();
	}

	public String formatMessager(LogRecord record) {
		return formatMessage(record);
	}

}
