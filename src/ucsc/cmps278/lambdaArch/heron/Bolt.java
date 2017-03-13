package ucsc.cmps278.lambdaArch.heron;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

@SuppressWarnings("serial")
public class Bolt extends BaseRichBolt {
    private OutputCollector collector;
    private Map<String, Integer> countMap;
    private int tupleCount;
    private String taskName;

    @SuppressWarnings("rawtypes")
	public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
      collector = outputCollector;
      countMap = new HashMap<String, Integer>();
      tupleCount = 0;
      taskName = topologyContext.getThisComponentId() + "_" + topologyContext.getThisTaskId();
    }

	public void execute(Tuple tuple) {
		String key = tuple.getString(0);
		
		  System.out.print(tuple.getString(0) + " ");	
	      tupleCount += 1;
	      if (tupleCount % 100 == 0) {
	        tupleCount = 0;
	        System.out.println(taskName + " : " + Arrays.toString(countMap.entrySet().toArray()));
	      }

	      if (countMap.get(key) == null) {
	        countMap.put(key, 1);
	      } else {
	        Integer val = countMap.get(key);
	        countMap.put(key, ++val);
	      }

	      collector.ack(tuple);
	}
	
	@Override
	public void cleanup() {
	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
	}
  }
