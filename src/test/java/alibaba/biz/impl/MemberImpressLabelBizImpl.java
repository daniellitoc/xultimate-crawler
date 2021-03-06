package alibaba.biz.impl;

import javax.annotation.Resource;

import org.danielli.xultimate.jdbc.datasource.lookup.DataSourceContext;
import org.danielli.xultimate.shard.ShardInfoGenerator;
import org.danielli.xultimate.shard.dto.ShardInfo;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import alibaba.biz.MemberImpressLabelBiz;
import alibaba.dao.MemberImpressLabelDAO;
import alibaba.po.MemberImpressLabel;

@Service("memberImpressLabelBizImpl")
public class MemberImpressLabelBizImpl implements MemberImpressLabelBiz {

	@Resource(name = "memberImpressLabelDAO")
	private MemberImpressLabelDAO memberImpressLabelDAO;
	
	@Resource(name = "myBatisShardInfoGenerator")
	private ShardInfoGenerator shardInfoGenerator;
	
	@Override
	public void saveMemberImpressLabel(MemberImpressLabel memberImpressLabel) {
		if (memberImpressLabel.getCreateTime() == null) {
			memberImpressLabel.setCreateTime(new DateTime().toDate());
		}
		ShardInfo shardInfo = shardInfoGenerator.createShardInfo("crawler_db", "MEMBER", memberImpressLabel.getMemberId());
		DataSourceContext.setCurrentLookupKey(shardInfo.getVirtualRoutingDataSourceKey("crawler_db"));
		memberImpressLabelDAO.saveMemberImpressLabel(shardInfo.getPartitionedTableShardId(), memberImpressLabel);
	}

}
