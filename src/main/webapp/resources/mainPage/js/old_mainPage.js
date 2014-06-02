
/* jquery study~~~ */
$(document).ready(function(){
	$('#study').css('background','pink');
	$('#develop').css('background','yellow');
	$('#result').css('background','skyblue');
	//$('body ul #notice').hide();
	//var home = $('div ul');
	//home.find('#fCome').hide();
	//$('.tab-pane').hide();
	$('.carousel-inner #img1').width('1050px');
	$('.carousel-inner #img1').height('350px');
	
	$('.carousel-inner #img2').width('1050px');
	$('.carousel-inner #img2').height('450px');
	
	$('.carousel-inner #img3').width('1050px');
	$('.carousel-inner #img3').height('550px');
	
	/* facebookLink */
	//$('#facebookLink').fadeIn();
	//$('#facebookLink').slideDown();
	$('#facebookLink').slideDown();
	
	$('#div1').animate({
		top: 300,
		left: 300
		
	},1000);
	
	$('#div1').slideUp(2000);
	
	//$('#div1').text('말만? NO!, 생각만? NO!!'); // 텍스트가 교체! html()도 있다!
	//$('#div1').empty();  // div는 남아있지만 텍스트는 사라진다.
	
	//$('.carousel-inner #attrTest').attr('src', 'resources/img/acet.png'); // 요소의 속성값을 변경하는 메소드!
	//$('#searchInput').val('검색할 키워드를 넣어주세요!');
	$('#searchInput').width('20em');
	
	/* <span class="label label-success">Step 01.</span> */
	//$('.label').removeClass('label-success'); // 위와 같이 여러개의 class를 등록 가능! addClass()도 있음!

	/***** EVENT ******/
	// click
	$('#searchBtn').click(function(){
		//$('#searchInput').empty();
		alert("click 되었습니다.");
	});
	
	// mouseenter, mouseleave
	$('#searchInput').mouseenter(function(){
		$('#searchInput').val('검색할 키워드를 넣어주세요!');
	});
	
    $('#searchInput').mouseleave(function(){
    	$('#searchInput').val('');  // empty()가 안먹힘;;
    	//$('#searchInput').val('검색할 키워드를 넣어주세요!');
	});
    
    
    // focus, blur
    $('#searchInput').focus(function(){
    	$('#searchInput').val(''); // empty();
    });
	
    
    
    
});

// 사용자 이벤트 테스트 
/*window.onload=function(){
   var sBtn = window.document.getElementById("searchBtn");
   sBtn.addEventListener("click", function(e){
	   // 1. 이벤트 생성
	   var myEvent = document.createEvent("Event");

	   // 2. 이벤트 객체에 이벤트와 함께 담아 보낼 데이터 추
	   myEvent.data1 ="Sorry Not yet..Support! 검색은 루씬 검색엔진으로 할 예정 입니다!";

	   // 3. 이벤트 초기화
	   myEvent.initEvent("myEvent", false, false);

	   // 4. 이벤트 발생
	   sBtn.dispatchEvent(myEvent);	   
   });
   
   sBtn.addEventListener("myEvent", function(e){
       alert("검색은..!, target ="+e.target.id+", data1 ="+e.data1);

    });
}*/