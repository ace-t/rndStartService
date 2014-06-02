
/* jquery study~~~ */
$(document).ready(function(){
	$('#study').css('background','pink');
	$('#develop').css('background','yellow');
	$('#result').css('background','skyblue');
	//$('body ul #notice').hide();
	//var home = $('div ul');
	//home.find('#fCome').hide();
	//$('.tab-pane').hide();
	
	var imgAttr1 = $('.carousel-inner #img1');
	var imgAttr2 = $('.carousel-inner #img2');
	var imgAttr3 = $('.carousel-inner #img3');
	
	var studyPanel = $('#studyPanel');
    studyPanel.hide();
    
	
	//imgAttr1.width('1050px');
	//imgAttr1.height('350px');
	
	//imgAttr2.width('1050px');
	//imgAttr2.height('450px');
	
	//imgAttr3.width('1050px');
	//imgAttr3.height('550px');
	
	/* facebookLink */
	//$('#facebookLink').fadeIn();
	//$('#facebookLink').slideDown();
	$('#facebookLink').fadeIn();  // 없던것이 보이게!
	
	
	var div1=$('#div1');
		
	div1.animate({
		top: 300,
		left: 300
		
	},1000);
	
	div1.slideUp(2000);  // 있던것이 사라짐!
	
	//$('#div1').text('말만? NO!, 생각만? NO!!'); // 텍스트가 교체! html()도 있다!
	//$('#div1').empty();  // div는 남아있지만 텍스트는 사라진다.
	
	//$('.carousel-inner #attrTest').attr('src', 'resources/img/acet.png'); // 요소의 속성값을 변경하는 메소드!
	//$('#searchInput').val('검색할 키워드를 넣어주세요!');
	var searchInput=$('#searchInput');
	searchInput.width('20em');
	
	/* <span class="label label-success">Step 01.</span> */
	//$('.label').removeClass('label-success'); // 위와 같이 여러개의 class를 등록 가능! addClass()도 있음!

	/***** EVENT ******/
	// click
	var searchBtn = $('#searchBtn');
	searchBtn.click(function(){
		var searchKeyword = $('#searchInput');
		alert("click 되었습니다."+searchKeyword.val());
		var formTag = $('form .form-search');
		formTag.attr("action","/search/searchResult.json"); // ?searchKeyword="+searchKeyword.val()
		formTag.submit();
	});
	
	// mouseenter, mouseleave
	searchInput.mouseenter(function(){
		searchInput.val('검색할 키워드를 넣어주세요!');
	});
	
    searchInput.mouseleave(function(){
    	searchInput.val('');  // empty()가 안먹힘;;
    	//$('#searchInput').val('검색할 키워드를 넣어주세요!');
	});
    
    
    // focus, blur
    searchInput.focus(function(){
    	searchInput.val(''); // empty();
    });
    
    
    var studyDevBtn = $('div ul');
	//study.find('#studyDev').hide();
	studyDevBtn.find('#studyDev').click(function(){
		$('.tabbable').hide();
		studyPanel.show();
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