//将得到的时间格式化
function timeto6(timeValue){
    var value_array=timeValue.split(":");
    var temp="";
    for(i=0;i<value_array.length; i++){
        temp+=""+value_array[i];
    }
    return temp;
}

//将时间进行比较
function compareTime(time1,time2){

if(parseInt(trimLeftZero(timeto6(time1)))>parseInt(trimLeftZero(timeto6(time2)))){

     return 1;
}

if(parseInt(trimLeftZero(timeto6(time1)))==parseInt(trimLeftZero(timeto6(time2)))){

     return 0;
}


if(parseInt(trimLeftZero(timeto6(time1)))<parseInt(trimLeftZero(timeto6(time2)))){

     return -1;
}

}

//将得到的份额进行比较
function compareDouble(value1,value2){
      
          if(parseFloat(value1)-parseFloat(value2)>0.00001){
              return 1;
          
          }else if (parseFloat(value2)-parseFloat(value1)>0.00001){
              return -1;
          
          }else{
             return 0
          
          }
          
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
  
/************************************
* 正则表达式方式校验输入是否全部由数字字符组成
*************************************/
 function validReguNumber(testString){
		    if(isReguNumber(testString)){
		       return "";
		    
		    }
		    return "必须为数字字符组成";
 }


/************************************
* 正则表达式方式校验输入是否全部由英文字符组成
*************************************/
 function validReguEnglish(testString){
		    if(isReguEnglish(testString)){
		       return "";
		    }
		    return "必须为英文字符组成";
 }
 
/************************************
* 正则表达式方式校验输入是否全部由数字和英文字符组成
*************************************/
 function validReguNormalLetter(testString){
		    if(isReguNormalLetter(testString)){
		       return "";
		    }
		    return "必须为数字或英文字符";
 }
 
 
/************************************
* 正则表达式方式校验输入是否全部由数字字符 和  -  字符组成
*************************************/
 function validReguTelNumber(testString){
		    if(isReguTelNumber(testString)){
		       return "";
		    }
		    return "必须为数字字符或 - 组成";
 }
/************************************
* 正则表达式方式校验输入是否全部由数字,英文字符或'-'字符组成
*************************************/
 function validIdCode(testString){
		    if(isIdCode(testString)){
		       return "";
		    }
		    return "必须为数字,英文字符或'-'字符组成";
 }
function isIdCode(testString){
	var pat=/[^a-zA-Z0-9|\-]/g;
	if(pat.test(testString)){
	    return false;
	}
		return true;
}
/************************************
* 正则表达式方式校验输入是否全部由数字,英文字符或'_'字符组成
*************************************/
 function validParamID(testString){
		    if(isParamIdCode(testString)){
		       return "";
		    }
		    return "必须为数字,英文字符或'_'字符组成";
 }
function isParamIdCode(testString){
	var pat=/[^a-zA-Z0-9|\_]/g;
	if(pat.test(testString)){
	    return false;
	}
		return true;
}
/***************************
*日期格式检验函数
*检查2006/01/03 此类格式
****************************/
function validDate(dateValue){
	          
  if(isDate(dateValue))      
    return "";
  else
   return "格式不正确应为YYYY/MM/DD";
	         
}

/***************************
*日期格式检验函数
*检查2006/01/03 此类格式
****************************/
function validDate2(dateValue){
	          
  if(dateValue=="")
  return "";
  
  if(isDate(dateValue))      
    return "";
  else
   return "格式不正确应为YYYY/MM/DD";
	         
}

/***************************
*时间格式检查函数
*检查hhmmss此类格式的时间
*
****************************/	   	
function validTime(timeValue){
  
    
    if(checkTime(timeValue))
     return "";
    else
     return "格式不正确应为HH:mm:ss:00:00:00到23:59:59";

} 

function validTime2(timeValue){
  
    if(timeValue=="")
    return "";
    
    return validTime(timeValue);

} 
 
/******************************************************
    防sql注入校验函数，主要校验是否含有单引号，sql关键字等特殊符号
********************************************************/
function validParameterStr(value){
  
	if(value=="")
		return "";

	var re= /select|update|delete|exec|count|'|"|=|;|>|<|%/i;
	var sMsg = "不允许存在特殊字符和SQL关键字！"

	if ( re.test(value) )
	{   
		return sMsg;
	}
	//20160120 linly 允许大小写字母、数字、中文，不允许特殊字符
	var pat=/[^a-zA-Z0-9|\_\u4e00-\u9fa5\.]/g;
	if( pat.test(value))
	{	    	 
		return sMsg;
	}
	return "";
} 


/********************************************
*验证输入的字符串是否为正整数
*********************************************/
function valid_poslong(strvalue){

     if(isInteger(strvalue)){
          if(parseInt(strvalue)>0){
              return "";
          }
     }
     
     
     return "必须为正整数";

}

/****************************
*检查是否那已经选择了券商模式
*验证下拉框是否选择
*****************************/
function validSelect(select_value){

   if(select_value=="-1" || select_value=="!" || select_value==""){
      return "未选";
   }else{
   
      return "";  
   }


}

/********************************************
*验证交易名称是否输入
*********************************************/
function valid_trans_name(trans_name,vForm){

     if(vForm.secu_no.value=="00000000"){
     
         if(trans_name==""){
         
            return  "不能为空";
         }
     
     }
    
     return "";

}
/********************************************
*验证输入的字符串是否为正整数
*********************************************/
function valid_noneglong(strvalue){

     if(isInteger(strvalue)){
          if(parseInt(strvalue)>=0){
              return "";
          }
     }
     return "必须为大于等于0的整数";
}

/******************************************
*验证输入的字符串是否为整数
*******************************************/
function valid_long(strvalue){
     if(isInteger(strvalue)){
          return "";
     }
     return "必须为整数";

}

/******************************************
*
*验证大于等于0的实数
*******************************************/
function valid_notnegreal(strvalue){
      if(checknotNegReal(strvalue)){
             return "";
      }  
      return "必须为大于等于0的实数";
}


/******************************************
*
*验证大于0的实数
*******************************************/
function valid_posreal(strvalue){

   
      if(checkPosReal(strvalue)){
             return "";
      }
      return "必须为大于0的实数";
}


/**********************************************
*
*  验证折扣率   折扣率为0 ---1之间的实数
*
***********************************************/
function  valid_disrate(strvalue){

         if(checknotNegReal(strvalue)){        
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>1)
                return "必须为大于等于0,小于等于1的实数";        
         }else{        
               return "必须为大于等于0,小于等于1的实数";            
         }         
         return "";
}

/**********************************************
    验证折扣率   折扣率为0 ---100之间的实数
**********************************************/
function  valid_hunrate(strvalue){

         if(checknotNegReal(strvalue)){
         
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>100)
                return "必须为大于等于0,小于等于100的实数";
         
         }else{
        
                return "必须为大于等于0,小于等于100的实数";
             
         }
         
         return "";


}

/**********************************************
    验证折扣率   折扣率为0 ---100之间的实数
**********************************************/
function  valid_hunrate2(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
         
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>100)
                return "必须为大于等于0,小于等于100的实数";
         
         }else{
        
                return "必须为大于等于0,小于等于100的实数";
             
         }
         
         return "";


}

/*******************************************
*
*验证输入的字符传是否为实数
*********************************************/
function valid_real(strvalue){

   
      if(checkReal(strvalue)){
             return "";
      }
      
      return "必须为实数";



}


/*******************************************
*验证输入项必须全部为数字
********************************************/
function valid_number(strvalue){
    if(isNumber(strvalue,true)){
             return "";     
     }


     return "必须全为数字组成";
}

/*******************************************
*验证输入项必须全部为数字
********************************************/
function valid_number2(strvalue){
	if(strvalue==""){
		return "";
	}
    if(isNumber(strvalue,true)){
             return "";     
     }


     return "必须全为数字组成";
}





/****************************
*ip地址校验函数
*目前只检查ip4协议的地址，以后如果需要支持ip6只需对这个函数进行扩展
******************************/	   	
function validIp(ip){
    //alert("valid ip");
    
    if(checkIp4(ip))
    return "";
    else
    return "格式不正确应为×××.×××.×××.×××";
}


/****************************
*检查最小认购单位的格式
*
******************************/	   	
function validSubUnit(strvalue){

    if(strvalue != "0" && strvalue != "1" && strvalue != "10" && strvalue != "100" && strvalue != "500" && strvalue != "1000")
    {
       return "应该等于0、1、10、100、500、1000中的一个数！";
    }else{
        return "";
    }
    
}

function valid_casprd_code1(prd_code1,vForm){

     if(vForm.rate1.value!=""){
     
         if(prd_code1==""){
         
            return  "不能为空";
         }
     }
     return "";
}

/**********************************************
*级联控制查询条件的账号的输入根据输入的账号类型判断是否需要输入
***********************************************/
function valid_cascadeacc(acc,vForm){

     if(vForm.accKind.value!="!"){
     
         if(acc==""){
         
            return  "不能为空";
         }
     }
     return "";
}

/**********************************************
*级联控制查询条件的账号的输入根据输入的账号类型判断是否需要输入
***********************************************/
function valid_cascadeacckind(acckind,vForm){

     if(vForm.account.value!=""){
     
         return validSelect(acckind);
     }
     return "";

}

/************************************************************
* vailid_cacademaxamt校验级联控制的最大余额
*************************************************************/
function vailid_cacademaxamt(max_amt,vForm){
      
           var str= valid_notnegreal(max_amt);
           
           if(str==""){
           
                if(parseFloat(max_amt)<parseFloat(vForm.min_amt.value)){
                
                     return  "必须大于等于最小金额";
                
                }
           }
      
            return "";
}


/************************************************************
* vailid_cacademaxamt校验级联控制的最大余额
*************************************************************/
function vailid_cacademinamt(min_amt,vForm){
      
      var str= valid_notnegreal(min_amt);
           
           if(str==""){
           
                if(parseFloat(min_amt)>parseFloat(vForm.max_amt.value)){
                
                     return  "必须小于等于最大金额";
                
                }
           }
      
      
      
      return "";
}


/**********************************************
    验证为NUMERIC_11_4(11, 4)即0与1和7个0之间的数字
**********************************************/
function  valid_number_11_4(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
         
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>10000000)
                return "必须为大于等于0,小于等于10,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于等于10,000,000的实数";
             
         }
         
         return "";


}

/**********************************************
    验证为NUMERIC(16,2)即0与1和14个0之间的数字
**********************************************/
function  valid_number_16_2(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
               var index  = strvalue.indexOf(".");
               if(index > 0)
               { 
                   if(strvalue.length - index -1 > 2){
                       return "小数点后不能大于2位长度";
                   }
               }else if(index == 0){
               	    return "金额格式不正确";
               }              
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>=100000000000000)
                return "必须为大于等于0,小于100,000,000,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于100,000,000,000,000的实数";
             
         }
         
         return "";


}


function  valid_number_12_2(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
               var index  = strvalue.indexOf(".");
               if(index > 0)
               { 
                   if(strvalue.length - index -1 > 2){
                       return "小数点后不能大于2位长度";
                   }
               }else if(index == 0){
               	    return "金额格式不正确";
               }              
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>=10000000000)
                return "必须为大于等于0,小于10,000,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于10，000,000,000的实数";
             
         }
         
         return "";


}

function  valid_number_18_2(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
               var index  = strvalue.indexOf(".");
               if(index > 0)
               { 
                   if(strvalue.length - index -1 > 2){
                       return "小数点后不能大于2位长度";
                   }
               }else if(index == 0){
               	    return "金额格式不正确";
               }              
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>=10000000000000000)
                return "必须为大于等于0,小于10,000,000,000,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于10,000,000,000,000,000的实数";
             
         }
         
         return "";


}

function  valid_number_10_4(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
               var index  = strvalue.indexOf(".");
               if(index > 0)
               { 
                   if(strvalue.length - index -1 > 4){
                       return "小数点后不能大于4位长度";
                   }
               }else if(index == 0){
               	    return "金额格式不正确";
               }              
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>=1000000)
                return "必须为大于等于0,小于1,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于1,000,000的实数";
             
         }
         
         return "";


}
/**********************************************
    验证为NUMERIC(16,2)即0与1和14个0之间的数字,不能小于0
**********************************************/
function  valid_largeZeroNum_16_2(strvalue){
    if(strvalue==""){
        return "";
    }
    if(checknotNegReal(strvalue)){         
        if(parseFloat(strvalue)<=0 || parseFloat(strvalue)>=100000000000000){
            return "必须为大于0,小于100,000,000,000,000的实数";
        }
    }else{
        return "必须为大于0,小于100,000,000,000,000的实数"; 
    } 
    return "";
}
/**********************************************
    -大于-100,000,000,000,000,小于100,000,000,000,000的实数+
**********************************************/
function  _valid_number_16_2(strvalue){

         if(strvalue=="")
         return "";
         
         if(checkReal(strvalue)){
         
               if(parseFloat(strvalue)<=-100000000000000 || parseFloat(strvalue)>=100000000000000)
                return "必须为大于-100,000,000,000,000,小于100,000,000,000,000的实数";
         
         }else{
        
                return "必须为大于-100,000,000,000,000,小于100,000,000,000,000的实数";
             
         }
         
         return "";


}

/**********************************************
    验证为NUMERIC(16,3)即0与1和13个0之间的数字
**********************************************/
function  valid_number_16_3(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
         
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>10000000000000)
                return "必须为大于等于0,小于等于10,000,000,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于等于10,000,000,000,000的实数";
             
         }
         
         return "";


}
/**********************************************
    验证为NUMERIC(16,4),即0与1和12个0之间的数字
**********************************************/
function  valid_number_16_4(strvalue){

         if(strvalue=="")
         return "";
         
         if(checknotNegReal(strvalue)){
         
               if(parseFloat(strvalue)<0 || parseFloat(strvalue)>1000000000000)
                return "必须为大于等于0,小于等于1,000,000,000,000的实数";
         
         }else{
        
                return "必须为大于等于0,小于等于1,000,000,000,000的实数";
             
         }
         
         return "";


}

function bizCheckDate(startDate, endDate){
  var index = 0;
  //var startDate = startDate.value;
  index = startDate.search('/');
  var date1 = startDate.substring(0, index);
  startDate = startDate.substring(index+1);
  index = startDate.search('/');
  var date2 = startDate.substring(0, index);
  var date3 = startDate.substring(index+1);
  var nStart = new Number(date1 + date2 + date3);
    
  //var endDate = endDate.value;
  index = endDate.search('/');
  date1 = endDate.substring(0, index);
  endDate = endDate.substring(index+1);
  index = endDate.search('/');
  date2 = endDate.substring(0, index);
  date3 = endDate.substring(index+1);
  var nEnd = new Number(date1 + date2 + date3);  
  
  if(nStart > nEnd){
    return false;
  }
  return true;
}



/************************************************************
* 起始日期，结束日期级联控制
*************************************************************/
function valid_cacadestartdate(startdatevalue,vForm){
      
       
           if((vForm.endDate.value!="") && isDate(vForm.endDate.value) && (startdatevalue!="") && isDate(startdatevalue) ){
               
              
                if(!bizCheckDate(startdatevalue,vForm.endDate.value))
                return "不能大于结束日期";
           }
           
            return "";
}


/************************************************************
* 起始日期，结束日期级联控制
*************************************************************/
function valid_cacadeenddate(enddatevalue,vForm){
      
    
      
      if((vForm.startDate.value!="") && isDate(vForm.startDate.value) && enddatevalue!="" && isDate(enddatevalue) ){
               
                if(!bizCheckDate(vForm.startDate.value,enddatevalue))
                return "不能小于起始日期";
           }
           
      
      return "";
}



/************************************************************
* vailid_cacademaxamt2校验级联控制的最大余额
*************************************************************/
function vailid_cacademaxamt2(max_amt,vForm){
      
           var str= valid_notnegreal(max_amt);
           
           if(str==""){
           
                if(parseFloat(max_amt)<=parseFloat(vForm.min_amt.value)){
                
                     return  "必须大于最小金额";
                
                }
           }
      
            return "";
}


/************************************************************
* vailid_cacademaxamt2校验级联控制的最大余额
*************************************************************/
function vailid_cacademinamt2(min_amt,vForm){
      
      var str= valid_notnegreal(min_amt);
           
           if(str==""){
           
                if(parseFloat(min_amt)>=parseFloat(vForm.max_amt.value)){
                
                     return  "必须小于最大金额";
                
                }
           }
      
      
      
      return "";
}


/************************************************************
* vailid_cacademaxamt3校验级联控制的金额上限
*************************************************************/
function vailid_cacademaxamt3(max_amt,vForm){
      	
           var str= valid_notnegreal(max_amt);
           
           if(str==""){
           
                if(parseFloat(max_amt)<=parseFloat(vForm.min_amt.value)){
                
                     return  "必须大于金额下限";
                
                }
           }
      
            return "";
}


/************************************************************
* vailid_cacademinamt3校验级联控制的金额下限
*************************************************************/
function vailid_cacademinamt3(min_amt,vForm){
      
      var str= valid_notnegreal(min_amt);
           
           if(str==""){
           
                if(parseFloat(min_amt)>=parseFloat(vForm.max_amt.value)){
                
                     return  "必须小于金额上限";
                
                }
           }
      
      
      
      return "";
}

/************************************************************
* vailid_cacademaxamt4校验级联控制的最高手续费
*************************************************************/
function vailid_cacademaxfee4(max_fee,vForm){
      
           var str= valid_notnegreal(max_fee);
           
           if(str==""){
           
                if(parseFloat(max_fee)<=parseFloat(vForm.min_fee.value)){
                
                     return  "必须大于最低手续费";
                
                }
           }
      
            return "";
}


/************************************************************
* vailid_cacademinamt4校验级联控制的最低手续费
*************************************************************/
function vailid_cacademinfee4(min_fee,vForm){
      
      var str= valid_notnegreal(min_fee);
           
           if(str==""){
           
                if(parseFloat(min_fee)>=parseFloat(vForm.max_fee.value)){
                
                     return  "必须小于最高手续费";
                
                }
           }
      
      
      
      return "";
}

/**************************************
*vForm为待检验的表单的表单句柄  checkArray为配置数组,
*needTransAuth, needReason这两项为保留项主要考虑某些项目可能需要授权,以后要用则扩展本函数
*本函数采用回调原理，其原理和c语言中函数指针的原理很相似
***************************************/
function checkForm(vForm,checkArray,needTransAuth, needReason){
    var es = vForm.elements;  //获取表单中所有的元素
	var i,j,k,size;           //循环语句计数器	
    var errorInfo="";         //提示信息
    var nums;                 //长度数组列表   
    
    var errSource=false;      //第一个出错的元素，主要用于focus
    var no=0;                   //错误信息序号

    for(i = 0; i < es.length; i++) {
    	   //added by  jyh  20071219  begin  增加对所有的  密码框  文本框  以及  textarea  框进行  '的校验
    	   
    	   if ( (es[i].type == "text") ||(es[i].type == "password")||(es[i].type == "textarea")){   //对于隐藏字段不做校验
			   
			if (es[i].value != "" ){
				if( es[i].value.indexOf("'") != -1 ){
					  
					  if(errorInfo==""){ //发现是第一次出错时候,提示否则继续检查别的元素,这样可以定位到指定控件 输入 单引号
                         errSource=es[i];
                         
                         errorInfo=errorInfo+"不能输入单引号.\n";
                         //alert(errorInfo);
                         break;
                      }       
                       
				}
				
			}
		  }
    	   //added by  jyh  20071219  end
    	   
        for(j=0;j<checkArray.length;j++){
            //找到需要检验格式的字段
        	//20130314-控件大小写一致性
            if(es[i].name.toLowerCase()==checkArray[j][0].toLowerCase()){

                    //modified by jyh 20070322 begin
                   
                       es[i].value=trim(es[i].value);    //这里暂时现对所有的控件进行去空,以后可能有选择性的去空
                    //modified by jyh 20070322 end
                    
                    
                   //1.进行为空校验
                   if(checkArray[j][2]=="chkinput"){
                        if(es[i].value==""){
                         if(errorInfo=="") //记录第一个出错的元素
                         errSource=es[i];
                         
                         no++;
                         errorInfo=errorInfo+""+no+"."+checkArray[j][1]+"不能为空.\n";
                         //alert(errorInfo);
                         break;
                        }
                   
                   }

                   //2.长度控制
                   if(checkArray[j][3]=='chklength'){
                   	  //alert(getStrByteLen(es[i].value));
                   	  nums=checkArray[j][6];
                       if(checkArray[j][7]+""=="undefined" || checkArray[j][7].toLowerCase()=="and"){ //长度控制在某个范围之内
                                                  
                             //按字节校验
                             if( getStrByteLen(es[i].value) >parseInt(nums[1]) ||  getStrByteLen(es[i].value)  <parseInt(nums[0])){
                                 if(errorInfo=="") //记录第一个出错的元素
                                  errSource=es[i];
                                  no++;
                                errorInfo+=""+no+"."+checkArray[j][1]+"长度必须"+nums[0]+"位到"+nums[1]+"位之间(一个汉字占两位)"+".\n";
                            }
                       
                       }else if(checkArray[j][7].toLowerCase()=="max"){
                       
                              if( getStrByteLen(es[i].value) >parseInt(nums[0]) ){
                                 if(errorInfo=="") //记录第一个出错的元素
                                  errSource=es[i];
                                  no++;
                                errorInfo+=""+no+"."+checkArray[j][1]+"最大长度不能超过"+nums[0]+"位(一个汉字占两位)"+".\n";
                            }
                       
                       
                       }else if(checkArray[j][7].toLowerCase()=="min"){
                       
                               if( getStrByteLen(es[i].value) <parseInt(nums[0]) ){
                                 if(errorInfo=="") //记录第一个出错的元素
                                  errSource=es[i];
                                  no++;
                                errorInfo+=""+no+"."+checkArray[j][1]+"最小长度不能小于"+nums[0]+"位(一个汉字占两位)"+".\n";
                            }
                       
                       }else{
                    
                               for(k = 0; k < nums.length; k++) {
									if(getStrByteLen(es[i].value) == parseInt(nums[k])){
										break;
									}
					           }
								
								if(k >= nums.length) {// 输入数据长度不在固定的几个值中
									if(errorInfo=="") //记录第一个出错的元素
                                       errSource=es[i];

                                    no++;
									errorInfo = errorInfo +""+no+"."+checkArray[j][1] + "长度应为 " + nums[0];
									for(k = 1; k <nums.length; k++)
										errorInfo = errorInfo + " 或 " + nums[k];
									errorInfo = errorInfo + " 位(一个汉字占两位).\n";
									//continue;    //如果长度不对则不再验证格式
									break;  //20070116提高效率
								}
                    
                        
                       }
                
                   }
                   
                   //3.格式检查，注意这里的格式检查函数返回值均为字符串，如果格式错误则返回信息，格式正确则返回""
                   if(checkArray[j][4]=="chkformat" && checkArray[j][8]+""!="undefined" && checkArray[j][8]+""!=""){
                                      	     //如果返回信息不为空则右错误
                   	    var info= checkArray[j][8](es[i].value);
                  	     if(info!=""){
                   	       if(errorInfo=="") //记录第一个出错的元素
                             errSource=es[i];
                           no++;
                   	       errorInfo=errorInfo+""+no+"."+checkArray[j][1]+info+".\n";
                   	       break;//20070116 提高效率
                   	     
                   	     }
                   	
                     
                   }
                   
                  //alert( checkArray[j][9]+"");
                   //4. 级连校验主要用于预先不知道该元素是否需要校验而需要根据其他元素的值动态去校验的情况
                   if(checkArray[j][5]=="chkcascade" && checkArray[j][9]+""!="undefined" && checkArray[j][9]+""!=""){
                                      	     //如果返回信息不为空则右错误
                   	    //alert("cascade call");
                   	    
                   	    var info= checkArray[j][9](es[i].value,vForm);  //注意级连校验函数需要将表单句柄传入函数体中
                  	     if(info!=""){
                   	       if(errorInfo=="") //记录第一个出错的元素
                             errSource=es[i];
                           
                           no++;
                           
                   	       errorInfo=errorInfo+""+no+"."+checkArray[j][1]+info+".\n";
                   	     
                   	     }
                   	
                     
                   }
                   
                   
                   
                   break;
        
            }
        
        
        }
    
    
    }

 //如果错误信息不为空则返回false 否则返回true
 if(errorInfo!=""){
 //alert(errSource.type);
  try{  //增加容错处理
  if(errSource.type!="hidden")
      if( (errSource.type=="text") || (errSource.type=="textarea") ){
          errSource.select();  //定位到第一个出错的地方
      }else{
          errSource.focus();  //定位到第一个出错的地方
      }
  }catch(e){
  }
  
  errorInfo="提示：\n"+errorInfo;
  alert(errorInfo);
 return false;
}


  //增加授权校验框，如果需要校验则调用授权校验框，授权成功返回true,授权失败返回false
	if((needTransAuth+"")=="true") {
		if(!transAuth(vForm,needReason))
			return false;
	}

 return true;
	
}	

/////////////////////////////////////////////////格式校验底层封装/////////////////////////////////////////////////////////////////////


/********************************
*去掉字符串的非第一个0的0
********************************/
function trimLeftZero(str){
    var tmp;
    
    tmp=str;
    
    while((tmp.substring(0,1)=="0")&&(tmp.length>1)){
    tmp=tmp.substring(1,tmp.length);
    }
    return tmp;
}




/**********************************
*ip4协议ip地址校验函数
*************************************/
function checkIp4(ip4){
var temp=ip4;

if(temp.length<7)  
return false;

var i=temp.indexOf(".");

if(i==-1)
return false;

var value_array =temp.split(".");  

if(value_array.length!=4)
return false;

for ( loop=0; loop < value_array.length;loop++)
{    
    if( !isNumber(value_array[loop]) ||  parseInt(value_array[loop])<0 || parseInt(value_array[loop])>255)
       return false;
}

 return true;

}

/*********************************************
*检查非负实数
*
***********************************************/

function checknotNegReal(sData) {    //如果不输则默认为0
    if( (sData.length == 0) || (!isData(sData)) || (parseFloat(sData) < 0) ) {
        return false;
      }  
      return true;
}

/********************************************
*检查正实数
********************************************/
function checkPosReal(sData){
    if( (sData.length == 0) || (!isData(sData)) || (parseFloat(sData) <= 0) ) {
        return false;
      }  
      return true;

}

/*********************************************
*
*检查实数
***********************************************/
function checkReal(sData) {    //如果不输则默认为0
    if( (sData.length == 0) || ( !isData(sData) )  ) {
        return false;
      }  
      return true;
}

	/********************************************************
	* 检查是否为全数字   如果输入值为空或全数字返回true  否则返回false
	**********************************************************/
	function isReguNumber(testString){
		var pat=/[^\d]/g
	
		if(pat.test(testString)){
			
			return false;
			 
		}
		
		return true;
	}
	/*********************************************************
	* 检查是否为全英文   如果输入为空或者全英文字符返回true  否则返回false
	**********************************************************/
	function isReguEnglish(testString){
		var pat=/[^a-z|A-Z]/g
		if(pat.test(testString)){
			return false;
		}
		return true;
	}
	/*******************************************************************
	*检查是否为电话号码  如果输入为空或者 由 - 和数字组成  返回true  否则返回false
	*********************************************************************/
	function isReguTelNumber(testString){
		var pat=/[^\d|\-]/g
		if(pat.test(testString)){
        return false;
		}
		return true;
	}
	/********************************************************************
	*检查是否为正常字符  如果输入为空或者 全部由字母和数字组成则返回true  否则返回false
	********************************************************************/
	function isReguNormalLetter(testString){
		var pat=/[^a-zA-Z0-9]/g;
		if(pat.test(testString)){
	          return false;
		}
		return true;
	}



