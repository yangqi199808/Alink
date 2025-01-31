package com.alibaba.alink.operator.batch.sql;

import org.apache.flink.ml.api.misc.param.Params;

import com.alibaba.alink.common.annotation.NameCn;
import com.alibaba.alink.common.annotation.NameEn;
import com.alibaba.alink.operator.batch.BatchOperator;
import com.alibaba.alink.params.sql.DistinctParams;

/**
 * Remove duplicated records.
 */
@NameCn("SQL操作：Distinct")
@NameEn("SQL Distinct Operation")
public final class DistinctBatchOp extends BaseSqlApiBatchOp <DistinctBatchOp>
	implements DistinctParams <DistinctBatchOp> {

	private static final long serialVersionUID = 2774293287356122519L;

	public DistinctBatchOp() {
		this(new Params());
	}

	public DistinctBatchOp(Params params) {
		super(params);
	}

	@Override
	public DistinctBatchOp linkFrom(BatchOperator <?>... inputs) {
		String[] selectedCols = getSelectedCols();
		if (null == selectedCols) {
			this.setOutputTable(inputs[0].distinct().getOutputTable());
		} else {
			this.setOutputTable(inputs[0].select(selectedCols).distinct().getOutputTable());
		}
		return this;
	}
}
