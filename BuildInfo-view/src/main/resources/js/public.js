function isTrueName(s){
    var patrn=/^([a-zA-Z0-9]|[_.@]){3,16}$/;   //用户名为3-16位字符   
    if (!patrn.test(s)) return false;  
    return true;  
}

function checkQuote(elements){
	var sVal = false;
	if ( (elements == null )||(elements.length < 1) )
		return sVal;
	for ( i = 0 ; i < elements.length ; i ++ ){
		if ( (elements[i].type == "text") ||(elements[i].type == "password")||(elements[i].type == "textarea")){
			elements[i].value = trim(elements[i].value);
			if (elements[i].value != "" ){
				if( elements[i].value.indexOf("'") != -1 ){
					alert("不能输入单引号");
					sVal = true;
					elements[i].focus();
					break;
				}
				
			}
		}
	}
	return sVal ;
}

function isPasswd(s)              
{                                 
  var patrn=/^(\w){6,10}$/;
    if (!patrn.exec(s)) return false;  
    return true;                          
}
//20090119-01-修改isDate()验证日期的方法-判断日期格式是不是符合 
function isDate(strDate){
    var re=/^(\d{4})([\/])(\d{2})([\/])(\d{2})/; 
    //判断日期格式符合YYYY/MM/DD标准  
    if(re.test(strDate)){ 
        var DateArray=strDate.split("/"); 
        var dateElement=new Date(DateArray[0],parseInt(DateArray[1],10)-1,DateArray[2]); 
        //判断日期逻辑        
        if(!((dateElement.getFullYear()==parseInt(DateArray[0],10))
           &&((dateElement.getMonth()+1)==parseInt(DateArray[1],10))
           &&(dateElement.getDate()==parseInt(DateArray[2],10)))) { 
            return false;   
        }else{ 
            return true;
        } 
    } else { 
     return false;
    }
}
/**
判断是否是闰年的方法
**/
function isLeapYear(year){
    if(year % 4==0 && (year % 100 !=0 || year % 400==0)){
        return true;
    } 
    return false;
}

/*结束日期不能小于起始日期*/
function checkEndDate(startDate, endDate){
  var index = 0;
  var startDate = startDate.value;
  index = startDate.search('/');
  var date1 = startDate.substring(0, index);
  startDate = startDate.substring(index+1);
  index = startDate.search('/');
  var date2 = startDate.substring(0, index);
  var date3 = startDate.substring(index+1);
  var nStart = new Number(date1 + date2 + date3);
  var re=/\d{4}\/\d{2}\/\d{2}/g;
  var endDate = endDate.value;
  index = endDate.search('/');
  date1 = endDate.substring(0, index);
  endDate = endDate.substring(index+1);
  index = endDate.search('/');
  date2 = endDate.substring(0, index);
  date3 = endDate.substring(index+1);
  var nEnd = new Number(date1 + date2 + date3);  
  if(startDate == ""){
    alert("起始日期不能为空！");
    return false;
  }
  if(nStart > nEnd){
  	alert("结束日期不能小于起始日期!");
  	return false;
   }
  return true;
}
/*
	Function Name:				isNumber
	Description	 :				to check whether the string is representing a number
	Params:
		sNumber							one number value string
		prefixZeroAllowed		whether allow a prefix 0 in the number string.
	Return Value:
		true								if the string represents a number
		false							if not		
*/
function isNumber(sNumber,prefixZeroAllowed){
	var sVal = true;
	var s = "";
	var len = sNumber.length;
	if(len==0){
		return false;
	}
	for(var i=0;i<len;i++){
		var c = sNumber.charAt(i);
		if(c>='0'&&c<='9'){
			if(i==0){
				if(prefixZeroAllowed==false){
					if(c=='0'&&len>1){
						sVal=false;
						break;
					}
				}else{
					if(c=='0'&&len>1){ c="" }
				}
			}
			s = s+c;
		}
		else{
			sVal = false;
			break;
		}
	}
	return sVal;
}


/*
	Function Name:				isInteger
	Description	 :				to check whether the string is representing an integer
	Params:
		sNum								one number value string
	Return Value:
		true								if the string represents an integer
		false								if not		
*/
function isInteger(sNum){
    var re=/^([+-]?\d+)$/;
    return re.test(sNum);
}

function isYear(sYear){
    var re=/^([0-9]+[0-9]+[0-9]+[0-9])$/;
    return re.test(sYear);
}
/*
	Function Name:				isNegative
	Description	 :				to check whether the string is representing a negative number
	Params:
		sNum								one number value string
	Return Value:
		true								if the string represents a negative number
		false								if not
*/
function isNegative(sNum){
    var re=/^[-](\d+|([0]?[\.]\d*)|([1-9]+[0-9]+[\.]\d*)|([1-9]+[\.]\d*))$/;
    return re.test(sNum);
}
/*
	Function Name:				isData
	Description	 :				to check whether the string is representing a data
	Params:
		sData								one number value string
	Return Value:
		true								if the string represents a data
		false								if not
*/
function isData( sData ){
  var re=/^[+-]?(\d+|([0]?[\.]\d*)|([1-9]+[0-9]+[\.]\d*)|([1-9]+[\.]\d*))$/;
  return re.test(sData);
}

/*
	Function Name:	trim
	Description	 :	to trim leading and ending blanks of string
	Params:					str	-- input string
	Return Value:		trimmed string
*/
function trim(str){
	while((str.charCodeAt(0)==32)&&(str.length>=1)){
  	str=str.substring(1,str.length);
	}
	while((str.charCodeAt(str.length-1)==32)&&(str.length>=1)){
		str=str.substring(0,str.length-1);
	}
	return str;
}
/*
	Function Name:				IsAphameric
	Description	 :				检查是否为字母数字或字符。
	Params:								str		input  string
	Return Value:
		如果是中文，返回false
	Author:					
	CreatedTime:			
*/
function IsAphameric(str){
  for(var i=0;i<str.length;i++){
    if(str.charAt(i)>"z"){
      return false;
    }
  }
  return true;
}
function FixedLength(str, len){    
    var i = 0; 
    var addNum =0;
    var k = str.length;
    for(i=0; i<k; i++){  
        if(str.charAt(i)>'z'){ //为汉字
            addNum = addNum + 1;
        }
    }
    k = len - (k+addNum);  
    for (i=0; i< k; i++){
        str += " ";
    }
    return str;
    
}

function checkNumber(sNumber) {
    if((sNumber.value.length > 0) && (!isNumber(sNumber.value))) {
        alert("请输入整数！");
        sNumber.focus();
        sNumber.value = ""; 
	return;
    }
}

function checkData(sData) {
    if((sData.value.length > 0) && (!isData(sData.value))) {
        alert("请输入数字！");
        sData.focus();
        sData.value = "";        
		return;
	}
}

function checkPlusData(sData) {
    if((sData.value.length > 0) && (!isData(sData.value) || (sData.value < 0))|| (sData.value==0)||sData.value=="") {
        alert("请输入正数！");
        sData.focus();
        sData.value = "";
        return false;
      }  
     var index=sData.value.indexOf(".");
     var Length=sData.value.length;
     if(index=="0"){
    	 alert("输入数据不合法！");
    	 sData.focus();
         sData.value = "";        
 	    return false;
     }
    if(index!=-1&&Length>index+3) {
        alert("小数点后最多输入两位！");
        sData.focus();
        sData.value = "";        
	    return false;
    }  
      return true;
}

function checkFfsData(sData) {
    if((sData.value.length > 0) && (!isData(sData.value) || (sData.value < 0))|| sData.value==""){
        alert("请输入非负数！");
        sData.focus();
        sData.value = "";
        return false;
      }  
    var index=sData.value.indexOf(".");
    var Length=sData.value.length;
    if(index!=-1&&Length>index+3) {
        alert("小数点后最多输入两位！");
        sData.focus();
        sData.value = "";        
	    return false;
    }  
      return true;
}

function checkPlusNumber(sNumber) {
    if((sNumber.value.length > 0) && (!isNumber(sNumber.value) || (sNumber.value < 0))||sNumber.value=="") {
        alert("请输入正整数！");
        sNumber.focus();
        sNumber.value = "";        
	    return false;
    }  
    var index=sNumber.value.indexOf(".");
    var Length=sNumber.value.length;
    if(index!=-1&&Length>index+3) {
        alert("小数点后最多输入两位！");
        sNumber.focus();
        sNumber.value = "";        
	    return false;
    }  
    return true;
}

function checkIdCode(id_code) {
    if(id_code.value.length!=15&&id_code.value.length!=18) {
        alert("身份证号码长度必须为15位或18位！");
        id_code.focus();
        id_code.value = "";        
	    return false;
    }  
    return true;
}

function checkDate(startDate, endDate){
  var index = 0;
  var startDate = startDate.value;
  index = startDate.search('/');
  var date1 = startDate.substring(0, index);
  startDate = startDate.substring(index+1);
  index = startDate.search('/');
  var date2 = startDate.substring(0, index);
  var date3 = startDate.substring(index+1);
  var nStart = new Number(date1 + date2 + date3);
  var endDate = endDate.value;
  index = endDate.search('/');
  date1 = endDate.substring(0, index);
  endDate = endDate.substring(index+1);
  index = endDate.search('/');
  date2 = endDate.substring(0, index);
  date3 = endDate.substring(index+1);
  var nEnd = new Number(date1 + date2 + date3);  
  if(nStart >= nEnd){
  	alert("下一交易日不能小于等于本交易日期!");
  	endDate.focus();
  	return false;
  }
  return true;
}

//根据指定开始年,填充select下拉框的选项 add by jinjh 20030407
//使用方法: 在 selectWnd 定义后面 并且在</body>前面调用此函数
//参数说明: selectWnd-要填充下拉框, beginYear-开始年, selectedYearMonth-默认选中年月
// ....
//  <select name="testSelectWnd" ></select>
// ....
//<script language="JavaScript">
//    fillYearMonth(formList.testSelectWnd, 2002, 2003, 2 );
//</script>
//</body>

function fillYearMonth( selectWnd, beginYear, selectedYearMonth ){
   var currDate = new Date();
   var currYear = currDate.getYear();
   var currMonth = currDate.getMonth();
   for ( var i = beginYear; i < currYear; i++ ){
      // 1月~9月
      for( var j = 1; j<10; j++ ){
          var option1=document.createElement("Option"); 
          option1.value = "" + i + "0" + j;
          option1.text = "" + i + "年0" + j + "月";  
          selectWnd.add(option1);
          if ( option1.value == selectedYearMonth ){
              option1.selected = "selected";  
          }  
      }
      //10月~12月
      for( var k = 10; k <= 12; k ++ ){
          var option2=document.createElement("Option"); 
          option2.value = "" + i + k;
          option2.text = "" + i + "年" + k + "月";
          selectWnd.add(option2);
          if ( option2.value == selectedYearMonth ){
              option2.selected = "selected";  
          } 
      }
   }
   //当前年
   for( var m = 1; m <= currMonth; m++ ){
      var option3=document.createElement("Option"); 
      if ( m < 10 ) {
          option3.value = "" + currYear + "0" + m;
          option3.text = "" + currYear + "年0" + m + "月";
      }else{
          option3.value = "" + currYear + m;
          option3.text = "" + currYear + "年" + m + "月";
      }
      selectWnd.add(option3);
      if ( option3.value == selectedYearMonth ){
          option3.selected = "selected";  
      }
   }
}
//根据指定开始年,填充select下拉框的选项 add by jinjh 20030407
//使用方法: 在 selectWnd 定义后面 并且在</body>前面调用此函数
//参数说明: selectWnd-要填充下拉框, beginYear-开始年, endYear-结束年 selectedYear-默认选中年
function fillYear( selectWnd, beginYear, endYear, selectedYear ){
   for ( var year = beginYear; year <= endYear; year++ ){
       var option=document.createElement("Option"); 
       option.value = "" + year;
       option.text = "" + year + "年";  
       selectWnd.add(option);
       if ( year == selectedYear ){
           option.selected = "selected";  
       }  
   }
}

//根据指定开始年,填充select下拉框的选项 add by jinjh 20030407
//使用方法: 在 selectWnd 定义后面 并且在</body>前面调用此函数
//参数说明: selectWnd-要填充下拉框, selectedMonth-默认选中月
function fillMonth( selectWnd, selectedMonth ){
    for ( var month = 1; month <= 12; month++ ){// 1月~9月
        var option=document.createElement("Option"); 
        if( month < 10 ){
      	    option.value = "0" + month;
            option.text  = "0" + month + "月"; 
        }else{
            option.value = "" + month;
            option.text  = "" + month + "月"; 
        } 
        selectWnd.add(option);
        if ( month == selectedMonth ){
            option.selected = "selected";          
        }  
    }
}

//动态更新select选择框中的选项的顺序
//选中项上移
//selectWnd - select控件名
//add by jinjh 200309
function select_up( selectWnd ){
    var selIndex = selectWnd.selectedIndex;
    if( selIndex == -1 ){
        alert("未选择选项，不能上移");
        return;
    }
    if( selIndex == 0 )
        return;
    var option = selectWnd.item(selIndex);
    selectWnd.remove(selIndex);
    selectWnd.add(option, (selIndex -1 ) );    
}
//动态更新select选择框中的选项的顺序
//选中项下移
//selectWnd - select控件名
//add by jinjh 200309
function select_down(selectWnd){
    var selIndex = selectWnd.selectedIndex;
    if( selIndex == -1 ){
        alert("未选择选项，不能下移");
        return;
    }
    if( selIndex == selectWnd.length - 1 )
        return;
    var option = selectWnd.item(selIndex);
    selectWnd.remove(selIndex);
    selectWnd.add(option, selIndex+1 ); 
}
//对多选框中选中的选项组成字符串，以"|"相隔
//selectWnd - select多选框的名字
//返回 - 组好后的字符串
//add by jinjh 200309
function getSelectedString(selectWnd){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var option = selectWnd.item(i);
		if(option.selected){
			str += option.value;
			str += "|";
		}
	}
	return str;
}
//对多选框中选中的选项组成字符串，以指定字符相隔
//selectWnd - select多选框的名字
//split - 分割字符串
//返回 - 组好后的字符串
//add by jinjh 200309
function getSelectedStringS(selectWnd, split){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var option = selectWnd.item(i);
		if(option.selected){
			str += option.value;
			str += split;
		}
	}
	return str;
}

//对多选框中所有选项组成字符串，以"|"相隔
//selectWnd - select多选框的名字
//split - 分割字符串
//返回 - 组好后的字符串
//add by jinjh 200309
function getSelectAllString(selectWnd){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var option = selectWnd.item(i);
		str += option.value;
		str += "|";
	}
	return str;
}

//对多选框中所有选项组成字符串(包括值和名)，以"|"相隔
//selectWnd - select多选框的名字
//split - 分割字符串
//返回 - 组好后的字符串
//add by jinjh 200309
function getSelectAllString2(selectWnd){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var option = selectWnd.item(i);
		str += option.value;
		str += ".";
		str += option.text;
		str += "|";
	}
	return str;
}

//对多选框中选中的选项组成字符串，以指定字符相隔
//selectWnd - select多选框的名字
//split - 分割字符串
//返回 - 组好后的字符串
//add by jinjh 200309
function getSelectAllStringS(selectWnd, split){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var option = selectWnd.item(i);
		str += option.value;
		str += split;
	}
	return str;
}

//取一个select控件的选中项的option文本
function getSelectOption(selectWnd){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var option = selectWnd.item(i);
		if(option.selected){
		    str = option.text;
		    break;
	    }
	}
	return str;
}

function onbranch(branch_no,branch_list){
  var str;
  str = getSelectOption(branch_list);
  branch_no.value = branch_list.value;
}
function onbranche(branch_noe,branch_liste){
  var str;
  str = getSelectOption(branch_liste);
  branch_noe.value = branch_liste.value;
}

//取一个select控件的选中项的option文本
function getSelectOptionByValue(selectWnd, values){
	var str = "";
	var cnt = selectWnd.length;
	var i = 0;
	for( i = 0; i < cnt; i++ ){
		var myoption = selectWnd.item(i);
		if(values == myoption.value){
		    str = myoption.text;
		    break;
	    }
	}
	return str;
}

//页码控制
function toPage(action, actionDir, totalPage){
	var startDate = document.frmList.startDate;
	var endDate = document.frmList.endDate;
	if(typeof(startDate)!='undefined'){
		if(!isDate(startDate.value)){ 
	    	alert("请输入合法日期！"); 
		  	startDate.focus();
		  	startDate.value="";
		    return false; 
		}		
		}
	if(typeof(endDate)!='undefined'){
		if(!isDate(endDate.value)){ 
	    	alert("请输入合法日期！"); 
		  	endDate.focus();
		  	endDate.value="";
		    return false; 
		}		
	}
	
	if(typeof(startDate)!='undefined'&&typeof(endDate)!='undefined'){
		if(!checkEndDate(startDate,endDate)){ 
			   return; 
			}
	}
	
	if(!isNumber(document.frmList.currPage.value)){
		alert("请输入数字！");
		window.event.returnValue = false;
		return;
	}		
	var currPage = new Number(document.frmList.currPage.value);
	var pageTotal = new Number(totalPage);
	if(actionDir == "next"){
		currPage = currPage + 1;
	}
	if(actionDir == "prev"){
		currPage = currPage - 1;
	}
	if(currPage < 1 || currPage> pageTotal){
		alert("页数已超出范围！");
		window.event.returnValue = false;
		return;
	}
	document.frmList.currPage.value = currPage;
	document.frmList.action = action;
	document.frmList.submit();	
}

//解析字符串，delim为分隔符
function parseStr(str,delim){
	if(str==null) return null;
	var strArr = new Array();
	if(delim==null||delim.length<=0) {
		strArr[strArr.length] = str;
		return strArr;
	}
	var spot = str.indexOf(delim);
	while(spot>=0){
		strArr[strArr.length]=str.substring(0,spot);
		str = str.substring(spot+delim.length);
		spot = str.indexOf(delim);
	}
	strArr[strArr.length]= str;
	return strArr;
}
//查询机构
function tagsQueryDept(deptId, deptName, deptIdHidden){
  	showx = event.screenX - event.offsetX - 4; // + deltaX;
  	showy = event.screenY - event.offsetY + 18; // + deltaY;
  	var result=window.showModalDialog("../work/deptQry.html", "", "dialogWidth:440px; dialogHeight:330px; dialogLeft:"+showx+"px; dialogTop:"+showy+"px; status:no; directories:yes;scrollbars:no;Resizable=no; help=no"  );
  	if(result != null){
  	  	var resultArr = parseStr(result,"|");
      	deptId.value = resultArr[0];
      	deptIdHidden.value = resultArr[0];
      	deptName.value = resultArr[1];
    }
}
function tagsInputDept(deptId, deptName, deptIdHidden) {
	if (deptId.value != deptIdHidden.value) {
		deptName.value = "";
	}
}
/*
	函数:checkQuote
	功能：校验文本输入（含字符输入）中是否有单引号存在（对单引号的操作是否正确）
		  去除文本头尾的空格
	输入参数：document.form.elements  其中form 根据具体情况而改变
	返回：true  存在单引号 
		  false 不存在单引号
*/
function checkQuote(elements){
	var sVal = false;
	if ( (elements == null )||(elements.length < 1) )
		return sVal;
	for ( i = 0 ; i < elements.length ; i ++ ){
		if ( (elements[i].type == "text") ||(elements[i].type == "password")||(elements[i].type == "textarea")){
			elements[i].value = trim(elements[i].value);
			if (elements[i].value != "" ){
				if( elements[i].value.indexOf("'") != -1 ){
					alert("不能输入单引号");
					sVal = true;
					elements[i].focus();
					break;
				}
			}
		}
	}
	return sVal ;
}
//格式化输入的日期，如果不合理，则清空输入框
function formatDate(Obj){
	var srcDate = Obj.value;
	var dstDate;
	var date = new Date();
	var year = 0;
	var month = 0;
	var day = 0;
	var workArr;
	var checkedFlg = false;
	if (srcDate.length == 0) {
		return false;
	}
	switch (srcDate.length) {
		//例：客户输入212，转化后：2004/02/12
		case 3:
			year = date.getYear();
			month = "0" + srcDate.substr(0,1);
			day = srcDate.substr(1,2);
			checkedFlg = true;
			break;
		//例：客户输入0212，转化后：2004/02/12
		case 4:
			year = date.getYear();
			month = srcDate.substr(0,2);
			day = srcDate.substr(2,2);
			checkedFlg = true;
			break;
		//例：客户输入20040212，转化后：2004/02/12
		case 8:
			if (!isNaN(srcDate)) {
				year = srcDate.substr(0,4);
				month = srcDate.substr(4,2);
				day = srcDate.substr(6,2);
				checkedFlg = true;
			}
			break;
		//例：客户输入2004?02?12，转化后：2004/02/12
		case 10:
			year = srcDate.substr(0,4);
			month = srcDate.substr(5,2);
			day = srcDate.substr(8,2);
			checkedFlg = true;
	}
	//处理客户输入 2004?2?12, 2004?12?2, 2004?2?2之类的情况,其中的问号只能是：".", "/", "-"三类
	if (checkedFlg == false && srcDate.length > 7 && isNaN(srcDate)) {
		var dateArr1 = srcDate.split(".");
		var dateArr2 = srcDate.split("/");
		var dateArr3 = srcDate.split("-");
		workArr = dateArr1.length == 3?dateArr1 : (dateArr2.length == 3?dateArr2 : (dateArr3.length == 3?dateArr3:workArr));
		if (workArr != null && workArr.length == 3) {
			year = workArr[0];
			month = workArr[1].length == 1?"0" + workArr[1]:workArr[1];
			day = workArr[2].length == 1?"0" + workArr[2]:workArr[2];
		}
	}	
	if (isValidDate(year, month, day)) {
		dstDate = year + "/" + month + "/" + day;
		Obj.value = dstDate;
		return true;
	}else {
		Obj.value = "";
		alert("请正确输入日期！");
		Obj.focus();
		return false;
	}
}

//判断是否是一个有效的日期（年月日）
function isValidDate(year, month, day){
	var testDate = new Date(year,2,2);
	year = year.toString();
	month = month.toString();
	day = day.toString();
	if (isNaN(year) || isNaN(month) || isNaN(day) 
		|| year.split(".").length > 1 || month.split(".").length > 1 || day.split(".").length > 1){
		return false;
	}
	testDate.setYear(year);
	testDate.setMonth(month - 1);
	testDate.setDate(day);
	if (year == testDate.getYear() && month == (testDate.getMonth() + 1) && day == testDate.getDate()) {
		return true;
	}else if ((year >= 1900 && year < 2000) && ((year - 1900) == testDate.getYear()) && month == (testDate.getMonth() + 1) && day == testDate.getDate()){
		return true;
	}else {
		return false;
	}
}
//判断输入字符串是否越界（长度超出要求），越界返回true，否则返回false
function isStrOverflow(validLen, srcStr) {
	if ( getStrByteLen(srcStr) > validLen){
		return true;
	}
	return false;
}
//得到以字节为单位的字符串长度
function getStrByteLen(srcStr){
	var strLen = 0;
    for (var i=0; i < srcStr.length; i++) {
    	if (srcStr.charCodeAt(i) > 127) {
    		strLen += 2;
    	}else {
    		strLen += 1;
    	}
    }
    return strLen;
}

/*
	函数:formatMoneyObj
	功能：使用三位分隔方式来格式化金融数字
		例如 1234567.10  格式化后为1,234,567.10
	输入参数：obj 格式化前的金额输入对象
	返回：格式化后的金额输入对象
*/

function formatMoneyObj(obj){
	var numSrc = obj.value;
	var str;
	if(obj.value == null||obj.value == "")
		return;
	str = formatMoneyNum(numSrc);
	if ( str!= null&& str != "")
		obj.value = str;
    return obj.value;
}
/*
	函数:formatMoneyNum
	功能：使用三位分隔方式来格式化金融数字
		例如 1234567.10  格式化后为1,234,567.10
	输入参数：strNumber 格式化前的金额
	返回：格式化后的金额
*/
function formatMoneyNum(strNumber){
	var numSrc = strNumber;
	var numDest,numDestpart1,numDestpart2;
	var len,len1;
	numDest = "";
	var re=/^[+-]?(\d+|([0]?[\.]\d*)|([1-9]+[0-9]+[\.]\d*)|([1-9]+[\.]\d*))$/;
    if (!re.test(numSrc)) {
    	return numDest;
    }
    len = numSrc.length;
    len1 = numSrc.indexOf(".");
    if (len1 == -1){
    	numDestpart1 = numSrc.substring(0,len);
    	numDestpart2 = "";
    } else {
   		numDestpart1 = numSrc.substring(0,len1);
   		numDestpart2 = numSrc.substring(len1+1,len);
    }
    numDestpart1 = formatIntPart(numDestpart1);
    if (len1 != -1){
    	numDestpart2 = formatPrecPart(numDestpart2);
    }
    if (len1 == -1){
    	numDest = numDestpart1 ;
    } else {
    	numDest = numDestpart1 + "." + numDestpart2 ;
    }
    return numDest;
}

function formatIntPart(strNum){
	var len = strNum.length;
	var strNumDest = "";
	var i = 0;
	start = 0;
	end = 0;
	var turn = len%3;
	if(len >3){
		strNumDest = strNumDest + strNum.substring(0,(turn==0)?3:turn) + ",";
	} else {
		strNumDest =  strNum;
		return strNumDest;
	}
	start = (turn==0)?3:turn  ;
	for ( i = 1 ; i < parseInt((len-1)/3)   ; i ++){
		end = i*3 + ((turn==0)?3:turn );
		strNumDest = strNumDest + strNum.substring(start,end) + ",";
		start = end;
	}
	strNumDest = strNumDest + strNum.substring(start,len);
	return strNumDest;
}
function formatPrecPart(strNum){
	var len = strNum.length;
	var strNumDest = "";
	var i = 0;
	if(len < 4 ){
		strNumDest =  strNum;
		return strNumDest;
	}
	for ( i = 1 ; i < parseInt((len-1)/3) + 1 ; i ++){
		strNumDest = strNumDest + strNum.substring((i-1)*3,i*3) + ",";
	}
	strNumDest = strNumDest + strNum.substring((i-1)*3,len) ;
	return strNumDest;
}

/*
	函数:unFormatMoneyNum
	功能：去除三位分隔的金融数字的","
		例如 1,234,567.10  格式化后为1234567.10 
	输入参数：strNumber 格式化前的金额
	返回：格式化后的金额
*/

function unFormatMoneyNum(strNumber){
	var strDest = "";
	var strArr = parseStr(strNumber,',');
	for ( i = 0 ; i < strArr.length ; i ++ ){
		strDest =  strDest + strArr[i];
	}
	return strDest;
}

/*
   处理复选框值，函数可以支持页面中多处使用复选框情况
   输入参数：name  复选框组名称 注意复选框的命名规则必须包含name值即可
   输入参数：index 表单在文档中的索引
     返回值：str   各个选择的复选框值列表，以竖线分隔  
   added by jyh 20061209       
*/
 function converCheckStr(name,index){ 
      var str="";   
      temp=name;
      for(i=0;i<document.forms[index].elements.length;i++){
	      if(document.forms[index].elements[i].type=="checkbox" && document.forms[index].elements[i].checked == true && document.forms[index].elements[i].name.indexOf(temp)!=-1){
	      		str=str+document.forms[index].elements[i].value+"|";
	      }else{
	       		continue;
	      }
      }
     return str;    
 }
/*
   处理复选框值，函数可以支持页面中多处使用复选框情况
   输入参数：name  复选框组名称 注意复选框的命名规则必须包含name值即可
   输入参数：index 表单在文档中的索引
     返回值：str   各个选择的复选框值列表，以竖线分隔  
   added by jyh 20061209       
*/
function  converSelect(name,index){
      var str="";   
      temp=name;
      var selectMode=document.getElementById("selectMode");
      if(selectMode.value=="0"){  //全不选 
	       for(var i=0;i<document.forms[index].elements.length;i++){
		       if(document.forms[index].elements[i].type=="checkbox"  && document.forms[index].elements[i].name.indexOf(temp)!=-1){
		           document.forms[index].elements[i].checked = false;
		       }else{
		           continue;
		       }
	       }
      }else if(selectMode.value=="1"){ //全选
           for(var i=0;i<document.forms[index].elements.length;i++){
		       if(document.forms[index].elements[i].type=="checkbox"  && document.forms[index].elements[i].name.indexOf(temp)!=-1){
		           document.forms[index].elements[i].checked = true;
		       }else{
		        continue;
		       }
           }
      }else if(selectMode.value=="2"){  //反选
	       for(var i=0;i<document.forms[index].elements.length;i++){
		       if(document.forms[index].elements[i].type=="checkbox"  && document.forms[index].elements[i].name.indexOf(temp)!=-1){
		            if(document.forms[index].elements[i].checked == false){
		           		document.forms[index].elements[i].checked =true;
		            }else{
		           		document.forms[index].elements[i].checked =false;
		            }
		       }else{
		            continue;
		       }
	       }
      }
     selectMode.options[0].selected=true; 
}
/* 
  输入参数:startdate   开始时间 
  输入参数:enddate     结束时间 
  输入参数:days        天数     0--不限制
  输出参数:boolean    true 两日期之间的天数在指定天数之内,false 两日期之间的天数在指定天数之外
*/
function  checkDays(startdate,enddate,days){
    if(days==0){
    	return true;
    }
	if(((gendate(enddate.value)-gendate(startdate.value))/(60*60*24*1000))>days){
  		return false;
	}else{
		return true; 
	} 
} 
/*
	功能:将字符传转化成日期 
	输入参数:  s  字符串日期
	输入参数:  日期型日期  
*/
	function gendate(s){
	    return	new Date(s);
	}
	
  function checkTime(begin_time,end_time){
    
	if(begin_time.value==""){
	   alert("请输入交易起始时间!");
	   begin_time.focus();
	   return false;
	}
	
	if(begin_time.value.length==6){
		var bHH = begin_time.value.substring(0,2);
	    var bMM = begin_time.value.substring(2,4);
	    var bSS = begin_time.value.substring(4,6);
	 if(!/^\d+$/.test(begin_time.value) || bHH>=24 || bHH<0 || bMM>=60 || bSS>=60){
	   alert("请输入正确的交易起始时间!");
	   begin_time.focus();
	   begin_time.select();
	   return false;
	}		
	}else if(begin_time.value.length==8 && begin_time.value.substring(2,3)==":" && begin_time.value.substring(5,6)==":"){
	    var bhh = begin_time.value.substring(0,2);
	    var bmm = begin_time.value.substring(3,5);
	    var bss = begin_time.value.substring(6,8);
	    if(!/^\d+$/.test(bhh) || !/^\d+$/.test(bmm) || !/^\d+$/.test(bss) || bhh>=24 || bhh<0 || bmm>=60 || bss>=60){
	      alert("请输入正确的交易起始时间!");
	      begin_time.focus();
	      begin_time.select();
	      return false;
	    }	
	}else{
	  alert("正确的时间格式为:HHMMSS 或 HH:MM:SS");
	  return false;
	}
	if(end_time.value==""){
	   alert("请输入交易结束时间!");
	   end_time.focus();
	   return false;
	}
	if(end_time.value.length==6){
		var eHH = end_time.value.substring(0,2);
  	    var eMM = end_time.value.substring(2,4);
	    var eSS = end_time.value.substring(4,6);
	 if(!/^\d+$/.test(end_time.value) || eHH>=24 || eHH<0 || eMM>=60 || eSS>=60){
	   alert("请输入正确的交易结束时间!");
	   end_time.focus();
	   end_time.select();
	   return false;
	}		
	}else if(end_time.value.length==8 && end_time.value.substring(2,3)==":" && end_time.value.substring(5,6)==":"){
	    var ehh = end_time.value.substring(0,2);
	    var emm = end_time.value.substring(3,5);
	    var ess = end_time.value.substring(6,8);    
	    if(!/^\d+$/.test(ehh) || !/^\d+$/.test(emm) || !/^\d+$/.test(ess) || ehh>=24 || ehh<0 || emm>=60 || ess>=60){
	      alert("请输入正确的交易结束时间!");
	      end_time.focus();
	      end_time.select();
	      return false;
	    }	
	}else{
	  alert("正确的时间格式为:HHMMSS 或 HH:MM:SS");
	  return false;
	}
	if(begin_time.value.length!=end_time.value.length){
	  alert("请输入匹配的起始时间和结束时间!");
	  return false;
	}
	if(begin_time.value.length==6 && end_time.value.length==6){
	  if(begin_time.value>end_time.value){
	   alert("起始时间不能小于结束时间!");
	   return false;
	}
	}else if(begin_time.value.length==8 && end_time.value.length==8){
	    var bhh = begin_time.value.substring(0,2);
	    var bmm = begin_time.value.substring(3,5);
	    var bss = begin_time.value.substring(6,8);
	    var ehh = end_time.value.substring(0,2);
	    var emm = end_time.value.substring(3,5);
	    var ess = end_time.value.substring(6,8);
	    var begin_time = bhh+bmm+bss;
	    var end_time = ehh+emm+ess;
	    if(begin_time>end_time){
	      alert("起始时间不能小于结束时间");
	      return false;
	    }
	}
    return true;
  }
///document.oncontextmenu=function(e){return false;}/* 屏蔽鼠标右键 */
/* 屏蔽F5,ALT+->,ALT+<-,CTL+N,shift+F10键值*/
window.document.onkeydown=function(e){
    if((window.event.altKey)&&(window.event.keyCode==37||window.event.keyCode==39)){
        alert("您不能使用ALT+方向键前进或后退网页！");   
        window.event.returnValue=false; 
        return false;  
    }    
    if(window.event.keyCode==116){                     //屏蔽   F5   刷新键   
        window.event.keyCode=0;   
        window.event.returnValue=false;  
        return false; 
    }   
    if((event.ctrlKey)&&(event.keyCode==78)){       //屏蔽   Ctrl+n   
        window.event.returnValue=false;  
        return false;  
    }   
    if((event.ctrlKey)&&(event.keyCode==82)){       //屏蔽   Ctrl+r    刷新组合键 
        window.event.returnValue=false;  
        return false;  
    }
    if((window.event.shiftKey)&&(event.keyCode==121)){   //屏蔽   shift+F10   
        window.event.returnValue=false;
        return false;    
    }   
};

function CheckLicense(licenseStatus){
	switch(licenseStatus){
		case '-1':
		    alert("对不起！License查询失败,请按确认继续!");
		    break;
		case '0':
		    break;//License有效不提示
		case '2':
		    alert("对不起！License商户数超出许可数,请按确认继续!");
		    break;
		case '3':
		    alert("对不起！License已经过期,请按确认继续!");
		    break;
		case '4':
		    alert("对不起！License非法,请按确认继续!");
		    break;
		case '5':
		    alert("对不起！License不存在,请按确认继续!");
		    break;   
		default :
		   alert("对不起！License查询失败,请按确认继续!");
	}
}
//初始化、指定处理函数、发送请求的函数
function ajaxRequest(url,processFunction) {
     var http_req = false;
    //开始初始化XMLHttpRequest对象
	if(window.XMLHttpRequest) { //Mozilla 浏览器
		http_req = new XMLHttpRequest();
		if (http_req.overrideMimeType) {//设置MiME类别
			http_req.overrideMimeType('text/xml');
		}
	} else if (window.ActiveXObject) { // IE浏览器
	    try {
			http_req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			
			}
		}
	}

	

	if (!http_req) { // 异常，创建对象实例失败
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
	http_req.onreadystatechange =function(){
	                                if (http_req.readyState == 4) { // 判断对象状态
										if (http_req.status == 200) { // 信息已经成功返回，开始处理信息
								            var responseInfo=http_req.responseText;
								            eval('processFunction(responseInfo)');
										} else { //页面不正常
									        alert("您所请求的页面有异常");
										}
								    }
	                             }
	// 确定发送请求的方式和URL以及是否同步执行下段代码
	http_req.open("post", url, true);
	http_req.send(null);
}
function IsAuth(trans_code,subtrans_code){
    ajaxRequest("../ajax/ajax0002.ajax?trSubCode="+trans_code+"&SubTransCode="+subtrans_code,getTransAuthId);
}


function getTransAuthId(responseInfo) {
    var info=responseInfo;   
    var value_array =info.split("|"); 
    if(value_array[0]=='0000'){
        var array = transAuth(document.all.frmList);
        if(array[0]){
        	var myForm = document.createElement("form"); 
        	myForm.method="post" ;
        	var myInput = document.createElement("input") ;
        	myInput.setAttribute("name", "AuthOpeCode") ; 
        	myInput.setAttribute("value", array[1]); 
        	myForm.appendChild(myInput) ; 
        	var myInput2 = document.createElement("input") ;
        	myInput2.setAttribute("name", "AuthOpePass") ; 
        	myInput2.setAttribute("value", array[2]); 
        	myForm.appendChild(myInput2) ; 
        	document.body.appendChild(myForm) ; 
        	myForm.submit() ; 
        	document.body.removeChild(myForm) ; 
 	
		    document.all.frmList.submit();   //授权通过
        } else {
        	return;
        }
    } else if(value_array[0]=='9999'||value_array[0]=='8888') {
		document.all.frmList.submit();//不需要授权
    } else {
        alert("错误码："+value_array[0]+" 错误信息："+value_array[1]);
    }
}
/**
 * 需授权的交易调用授权窗口
 */
function transAuth(vForm) {
    return(showModalDialog("../auth/transAuth.jsp?needReason=false", vForm, "dialogWidth:330px; dialogHeight:200px; center:yes;"));
}
function go_back(trcode,subtrcode){
	if(trcode==""||"null"==trcode) {
        window.parent.location.href="../";
	} else {
	    document.location.href="../request/"+trcode+"?trSubCode=def";
	}
}