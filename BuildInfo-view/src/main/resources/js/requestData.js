/**
 * 根据url请求数据,并将结果设置到span标签以及进度条中
 */
function processDataRequest(url,spanNode,processNode){
	$.ajax({
	    url: url,
	    success: function(data) {
	       var count = data.count,finishCount = data.finishCount;
	       var percent,value;
	       spanNode.html(finishCount+'/'+count);
	       if(count != 0){
	    	   percent = parseFloat(finishCount/count).toFixed(2);
	    	   
	    	   percent = percent * 100;
	       }else{
	    	   percent = 0;
	       }
	       processNode.attr("style", "width:"+percent.toFixed(2)+"%");
	       processNode.attr("aria-valuenow",percent.toFixed(2)+"%");
	       processNode.html(percent.toFixed(2)+"%");
	    }
    });
}