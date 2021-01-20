<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI 계산기</title>
<script type="text/javascript">



function fnValChk(obj){
	var val = obj.value;
	var pattern = /[^(0-9.)]/gi;
	if(pattern.test(val)){
        obj.value = val.replace(pattern,"");
    }
}
function fnChk(){
	var inHei = document.getElementById("height");
	var pattern0 = /^\d*[.]\d*$/; 
	 if(pattern0.test(inHei.value)){
	    	alert("소수점은 한번만 입력해주세여");
	    	inHei.focus();
	 }
	 if(document.getElementById("csNm").value == ""){
		 alert("이름을 입력해주세여");
		 document.getElementById("csNm").focus();
		 return false;
	 }
	 if(document.getElementById("height").value == ""){
		 alert("키를 입력해주세여");
		 document.getElementById("weight").focus();
		 return false;
	 }
	 if(document.getElementById("weight").value == ""){
		 alert("몸무게를 입력해주세여");
		 document.getElementById("weight").focus();
		 return false;
	 }
	 goNext();
}
function goNext(){
	var frm = document.frm;
	frm.action ="/views/bmiProc.jsp";
	frm.submit();
}

</script>
</head>
<body>
<form name="frm" id="frm" method="post" onsubmit="return false;"><!--get방식을 사용하면 입력한 데이터가 쿼리스트링으로 전송되어 URI에 노출되기 때문에 POST로 변경했다.-->
이름을 입력해주세요 : <input type="text" name="csNm" id="csNm" ><p />
키를 입력해주세요 : <input type="text" name="height" id="height" onkeyup="javascript:fnValChk(this);"><p/>
몸무게를 입력해주세요 :<input type="number" name="weight" id="weight"><p/>

<button id="btnSubmit" onclick="javascript:fnChk();">확인</button>
</form>
</body>
</html>