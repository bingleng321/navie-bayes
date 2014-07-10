package zx.soft.navie.bayes.db;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

/**
 * 处理后准备导回数据库中的记录
 * @author zhumm
 *
 */

public class SinaRecordWithOutputWritable implements Writable, DBWritable {

	private long wid; //微博ID
	private String cate; //处理后的分类结果

	public long getWid() {
		return wid;
	}

	public String getCate() {
		return cate;
	}

	public SinaRecordWithOutputWritable(long wid, String cate) {
		this.wid = wid;
		this.cate = cate;
	}

	@Override
	public void write(PreparedStatement statement) throws SQLException {
		statement.setLong(1, this.wid);
		statement.setString(2, this.cate);
	}

	@Override
	public void readFields(ResultSet resultSet) throws SQLException {
		this.wid = resultSet.getLong(1);
		this.cate = resultSet.getString(2);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(this.wid);
		Text.writeString(out, this.cate);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.wid = in.readLong();
		this.cate = Text.readString(in);
	}

}
