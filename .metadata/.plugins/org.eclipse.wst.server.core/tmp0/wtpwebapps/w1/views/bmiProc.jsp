<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI 결과</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String csNm = request.getParameter("csNm");
double height = Double.parseDouble(request.getParameter("height"));
double weight = Double.parseDouble(request.getParameter("weight"));

double result=0;

result = weight / Math.pow(height,2);

result = Math.floor(result*10)/10;
if(height > 2.5) {
	result = weight*10000 / Math.pow(height,2);
	result = Math.floor(result*10)/10;
}


String bmiStr = "";
if (result < 18.5) {
	bmiStr = "저체중";
} else if (result <= 23) {
	bmiStr = "정상";
} else if (result <= 25) {
	bmiStr = "경도비만";
} else if (result<= 30) {
	bmiStr = "고도비만";
} else if (30 < result) {
	bmiStr = "초고도비만";
}

%>
<%=csNm %>님의 키는 <%=height %> 몸무게는 <%=weight %> 입니다.<p/>
bmi는 <%=result %> 이고, <%=bmiStr %> 입니다.<p/><br>
이런 물건은 어떠신가요?<p/>
<%if(bmiStr.equals("저체중")){ 
%>
<a href="https://adcr.naver.com/adcr?x=mqd9bGLi2Qx6L5pILFN1T////w==k7Wl6jceDjjAsqT/60Vr4xXA17y14c1lQDgVPVku7Yzc7+5dNUvDIP5EUYP4XEFP1SD/NND9QFjsz56XNYS5TDa1GZb4fBnXlk6ylVxyAShXcjpY75Ll2Du8GDvpbO1vQcq7nSp/Gc/wrT+1TMRsoB4L5REGIg15N454GMuS635DbS1DM6f24W8IfAxlb1+RfqVBqItwyLg3nGduAq0UhCbyYo8AvAChLYUYJmpt1CgEui9mbp9+dd0PGCI1XUQfWT1vJmFx4uqHuh9PmfpjDBKOh7K9TUMTMbVvX1ouqNGH6P0T5po0NV9v2cfiCsMpvApUHjTJhFHXQXANKlQh+zXR4vd9AiHtoOmHEjWjYLz1TKkO5UzhyFkaGizgF/MnnuWYJxyywV6f0Q2gJtSq6bt3ABBKXAOWNUb1jsceYd5om3VhAJ0jd9g7+vk4a3IQsSi1tHOhPpjGLYjZmrOYZUCinggrZCZAZLhimMsbXtWZWnAYnDyK1vGYyzlC0ry/NAG12VL0s5v4bl2A/5cVk9vAa73KVGkaqu8WiTO/ehMP8OOBUc4HlGkFjfuB42/Mm6mzHqujnoe1dAtgdgwcfzNRJVxnCp/5tTPFVmTgocq1TKFVobpTb+QDZR5UdQzMwd9pHEo1Xb2RdksDGuyOY7dOTR17/mPPG0ygXQqXkAdN636cu9JbT2XkrRp+F06ZEeau+v1GZoW6iy7ctyOpMefhnZCEJOHjpqzQVi/8HMMODceMnbfIjr7AJfYhfyxiH+m1RTIO9nspOmogZStxGPdj7p4g9I1+JyGKcorbTrTYpyuFZTBK4Klm2KSAm9iG6TpR1t0slmLbdrlanZoZ0hQ==" target="_blank" class="thumbnail_thumb__3Agq6" rel="noopener" data-nclick="N=a:lst*A.image,r:1,i:82466262592"><img width="140" height="140" alt="[BSN] 신타6 엣지 초코맛 단백질보충제 1.82kg X 1통(48회) +간편팩증정" src="https://searchad-phinf.pstatic.net/MjAyMTAxMDRfMjI0/MDAxNjA5NzI0NzgxNjg2.VPGg9SHjqchsfHXTswdoJovh9mihO0WRL1pSITeKUg4g.tH_RtlzhOATyEymU556qwPaSF67P30sEvS7Mom6Sejgg.PNG/1923863-e4e5a662-d487-41de-a9c7-f16e2ba14678.png?type=f200"></a>
<%} %>
<%if(bmiStr.equals("정상")){ 
%>
<a href="https://cr.shopping.naver.com/adcr.nhn?x=mOxI3tlK3gnh4dPX0O%2B4hf%2F%2F%2Fw%3D%3DsZt7brUkKXXDBwUbqdwUVcp%2FpBBtSG%2BB7hs6Uy8DCB3ef99ETEvSiWmG8P40kbpSxBY%2F5VWCEda8p418Bv4QzEEbAoeRkvpJaJBMwPydFbM8QhkkHXK4%2FmSRy5icYE%2F27m2RfJqLF2Xkw4q4dIcYdA5d2IHYT%2Br4Ks1NxohKUhUuz8kGmHgXzMC1UHb8J4FMDMBbAUTLhEczrfo6o%2BFCYJ9koDZhZTyE2PqJzLGA4wO4TQKSkpMp5naGn6SWlmW4Gjg9UKh74%2FzSpLswi2fMS2c0Fp6fhOJRM8RPnTjq5G3LL%2Fowdnq7%2Fmfq67OVRzok0S5SJNLgIdS1XFCtZ5GETGAnWKNF9y30IZdAPlfpc8ZXlBrESKB%2FAN%2BeyV55nZnAyGtWOzT%2Fs1Q%2BpQfvkcbQokqG2NUEUdWnnR72HtWtxy0dKI194O3yVGRkTAKu5NZTn37xLGIzVnLruO2FdV%2FooFmrebY42GXIkUNBp5dyDg45z8fQE6UcocYdsKIORLNRzp%2BYV%2Ff1IV85CSIaXlXbAB30nwdVWVWgH2wNpALuMmZLzXvyeKIgiGg3O%2FR7bGWOvcTAJresIH7woseesF1SfuOYQsU7TtARBhTKL6TvT1FMfiiMSrMfwKLClRDlm8b9banWwDoShe6maJRTaS2ME1mToUtM4AK5oWmKbAJ6T3JOFbDf4gHI5rSMJU1BWcIOg&amp;nvMid=11927356299&amp;catId=50002425" target="_blank" class="thumbnail_thumb__3Agq6" rel="noopener" data-nclick="N=a:lst*N.image,r:2,i:11927356299"><img width="140" height="140" alt="센트룸 포맨 포우먼 실버/남성/멀티 코스트코 종합비타민" src="https://shopping-phinf.pstatic.net/main_1192735/11927356299.1.jpg?type=f140"></a>
<%} %>
<%if(bmiStr.equals("경도비만")){ 
%>
<a href="https://cr.shopping.naver.com/adcr.nhn?x=yNzZlEmrFCSLZmc2GxHIjP%2F%2F%2Fw%3D%3DsD8ucBFKP1Dncx9qpUELExlr09Ux2zr%2FU3EyRKt6zsfFzZ9gYmXUTYvz%2FMY5qJkIdEHMGWU2QNgWBADh62fNG43g84b46EFc%2BAkNjHGT%2BoabaH%2Bo1uYx3c%2F20TmNqYJspJbscX5utCfc%2FK52VI76k1pdzS7dFF4NlGlGtUsRi6wyKtQ%2FzIb93DqGKflHYX7DmMUr4xqr%2F52%2Bdo85SzQg5uwY7th%2Fb5X%2Fu%2F1YFVAUnhxaK4j5MTwF45Ni1%2FMJqrSg0sfViem1l2ZXIstQzQHgHYrEvVNceRSxPTPVsFrjP3QaqBjqt2lc6BAnF2r13bTw%2FVV3pn6Znl%2B9MAtsEE%2BZ8ouacYsA2T1ONC2M4R1%2F3Eb%2F9gaSlTqjRTdjbxTKaRSTCRJ%2BOzA3kE6rs7uekGLll4xO65AueXJZCN2mHf%2FhUTVly3tldpZcdYNEsGxNW%2BphEzfNVo1KcSVSazeZg7M%2BAaarWdnF1eS7yqupbBGhpGNXGOrmiPr3ujlpq2qFyZMiw0e%2FWS34dJqnVsr3adi3coUAIMaNrRxMpGd0cx1WF4Q%2FpIUaHu7aXpEo3zuBKxwvisYOkWFDoEUv4Ux%2BW01vhbduZ0Q6F70c0hxiD%2F2B0gZkE8Ud1cXBGA5S916T%2FxuEgXfV9GX3DHGFqof86DEpn1Pqo3V%2B6p3aafJnxZqnu3Pq2XJPHqy6v4o9aCwOVagPkn14m5RMtm4%2BrOmzHR0X9t7FDxektjKNxuEs%2Bb5dBXT3Njqh%2FZemCCOboDhnweAmG&amp;nvMid=81803829035&amp;catId=50001767" target="_blank" class="thumbnail_thumb__3Agq6" rel="noopener" data-nclick="N=a:lst*N.image,r:2,i:81803829035"><img width="140" height="140" alt="다이어트쉐이크 맛있는 단백질쉐이크 보조제 단기간 5일 식사대용 음식 단기 FMD 식단" src="https://shopping-phinf.pstatic.net/main_8180382/81803829035.6.jpg?type=f140"></a>
<%} %>
<%if(bmiStr.equals("고도비만")){ 
%>
<a href="https://cr.shopping.naver.com/adcr.nhn?x=yNzZlEmrFCSLZmc2GxHIjP%2F%2F%2Fw%3D%3DsD8ucBFKP1Dncx9qpUELExlr09Ux2zr%2FU3EyRKt6zsfFzZ9gYmXUTYvz%2FMY5qJkIdEHMGWU2QNgWBADh62fNG43g84b46EFc%2BAkNjHGT%2BoabaH%2Bo1uYx3c%2F20TmNqYJspJbscX5utCfc%2FK52VI76k1pdzS7dFF4NlGlGtUsRi6wyKtQ%2FzIb93DqGKflHYX7DmMUr4xqr%2F52%2Bdo85SzQg5uwY7th%2Fb5X%2Fu%2F1YFVAUnhxaK4j5MTwF45Ni1%2FMJqrSg0sfViem1l2ZXIstQzQHgHYrEvVNceRSxPTPVsFrjP3QaqBjqt2lc6BAnF2r13bTw%2FVV3pn6Znl%2B9MAtsEE%2BZ8ouacYsA2T1ONC2M4R1%2F3Eb%2F9gaSlTqjRTdjbxTKaRSTCRJ%2BOzA3kE6rs7uekGLll4xO65AueXJZCN2mHf%2FhUTVly3tldpZcdYNEsGxNW%2BphEzfNVo1KcSVSazeZg7M%2BAaarWdnF1eS7yqupbBGhpGNXGOrmiPr3ujlpq2qFyZMiw0e%2FWS34dJqnVsr3adi3coUAIMaNrRxMpGd0cx1WF4Q%2FpIUaHu7aXpEo3zuBKxwvisYOkWFDoEUv4Ux%2BW01vhbduZ0Q6F70c0hxiD%2F2B0gZkE8Ud1cXBGA5S916T%2FxuEgXfV9GX3DHGFqof86DEpn1Pqo3V%2B6p3aafJnxZqnu3Pq2XJPHqy6v4o9aCwOVagPkn14m5RMtm4%2BrOmzHR0X9t7FDxektjKNxuEs%2Bb5dBXT3Njqh%2FZemCCOboDhnweAmG&amp;nvMid=81803829035&amp;catId=50001767" target="_blank" class="thumbnail_thumb__3Agq6" rel="noopener" data-nclick="N=a:lst*N.image,r:2,i:81803829035"><img width="140" height="140" alt="다이어트쉐이크 맛있는 단백질쉐이크 보조제 단기간 5일 식사대용 음식 단기 FMD 식단" src="https://shopping-phinf.pstatic.net/main_8180382/81803829035.6.jpg?type=f140"></a>
<%} %>
<%if(bmiStr.equals("초고도비만")){ 
%>
<a href="https://cr.shopping.naver.com/adcr.nhn?x=yNzZlEmrFCSLZmc2GxHIjP%2F%2F%2Fw%3D%3DsD8ucBFKP1Dncx9qpUELExlr09Ux2zr%2FU3EyRKt6zsfFzZ9gYmXUTYvz%2FMY5qJkIdEHMGWU2QNgWBADh62fNG43g84b46EFc%2BAkNjHGT%2BoabaH%2Bo1uYx3c%2F20TmNqYJspJbscX5utCfc%2FK52VI76k1pdzS7dFF4NlGlGtUsRi6wyKtQ%2FzIb93DqGKflHYX7DmMUr4xqr%2F52%2Bdo85SzQg5uwY7th%2Fb5X%2Fu%2F1YFVAUnhxaK4j5MTwF45Ni1%2FMJqrSg0sfViem1l2ZXIstQzQHgHYrEvVNceRSxPTPVsFrjP3QaqBjqt2lc6BAnF2r13bTw%2FVV3pn6Znl%2B9MAtsEE%2BZ8ouacYsA2T1ONC2M4R1%2F3Eb%2F9gaSlTqjRTdjbxTKaRSTCRJ%2BOzA3kE6rs7uekGLll4xO65AueXJZCN2mHf%2FhUTVly3tldpZcdYNEsGxNW%2BphEzfNVo1KcSVSazeZg7M%2BAaarWdnF1eS7yqupbBGhpGNXGOrmiPr3ujlpq2qFyZMiw0e%2FWS34dJqnVsr3adi3coUAIMaNrRxMpGd0cx1WF4Q%2FpIUaHu7aXpEo3zuBKxwvisYOkWFDoEUv4Ux%2BW01vhbduZ0Q6F70c0hxiD%2F2B0gZkE8Ud1cXBGA5S916T%2FxuEgXfV9GX3DHGFqof86DEpn1Pqo3V%2B6p3aafJnxZqnu3Pq2XJPHqy6v4o9aCwOVagPkn14m5RMtm4%2BrOmzHR0X9t7FDxektjKNxuEs%2Bb5dBXT3Njqh%2FZemCCOboDhnweAmG&amp;nvMid=81803829035&amp;catId=50001767" target="_blank" class="thumbnail_thumb__3Agq6" rel="noopener" data-nclick="N=a:lst*N.image,r:2,i:81803829035"><img width="140" height="140" alt="다이어트쉐이크 맛있는 단백질쉐이크 보조제 단기간 5일 식사대용 음식 단기 FMD 식단" src="https://shopping-phinf.pstatic.net/main_8180382/81803829035.6.jpg?type=f140"></a>
<%} %><p/>
<a href="/views/bmi.jsp"> 다시하기 </a>
</body>
</html>